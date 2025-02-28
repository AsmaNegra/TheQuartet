package controllers;

import okhttp3.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Tache;
import entities.Evenement;
import entities.Fournisseur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GeminiClient {
    private static final String API_KEY = "AIzaSyBwY7vwRKPsC0NggJrMFFmWZDpDp1PLI_Q"; // Remplace par ta clé API
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;

//    public static void main(String[] args) {
//        Evenement event = new Evenement(); // À remplacer par un objet réel
//        Fournisseur vendor = new Fournisseur(); // À remplacer par un objet réel
//
//        List<Tache> tasks = generateTasksForVendor(event, vendor);
//
//    }

    public static List<Tache> generateTasksForVendor(Evenement evenement, Fournisseur fournisseur) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        String prompt = "Génère trois tâches pour un fournisseur impliqué dans l’événement '" + evenement + "'. " +
                "Le fournisseur est '" + fournisseur + "'. Pour chaque tâche, donne un nom et une courte description sous ce format :\n\n" +
                "Nom : [Nom de la tâche]\n" +
                "Description : [Description de la tâche]\n\n";

        JsonObject requestBody = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonObject contentObject = new JsonObject();
        JsonArray partsArray = new JsonArray();
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", prompt);
        partsArray.add(textPart);
        contentObject.add("parts", partsArray);
        contentsArray.add(contentObject);
        requestBody.add("contents", contentsArray);

        RequestBody body = RequestBody.create(requestBody.toString(), MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            // Extraire uniquement les tâches générées
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonArray candidatesArray = jsonObject.getAsJsonArray("candidates");

            if (candidatesArray != null && candidatesArray.size() > 0) {
                JsonObject firstCandidate = candidatesArray.get(0).getAsJsonObject();
                JsonObject content = firstCandidate.getAsJsonObject("content");
                JsonArray partsArrayResponse = content.getAsJsonArray("parts");

                if (partsArrayResponse != null && partsArrayResponse.size() > 0) {
                    JsonObject firstPart = partsArrayResponse.get(0).getAsJsonObject();
                    String rawText = firstPart.get("text").getAsString();

                    // Nettoyer la réponse de l'IA
                    rawText = rawText.replaceAll("\\*\\*", "").trim();

                    // Extraire les tâches sous forme d'objets Tache
                    return parseTasksFromAIResponse(rawText, evenement, fournisseur);
                }
            }
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // 🔹 Méthode pour extraire les tâches et les convertir en objets `Tache`
    private static List<Tache> parseTasksFromAIResponse(String aiResponse, Evenement evenement, Fournisseur fournisseur) {
        List<Tache> tasks = new ArrayList<>();
        String[] taskBlocks = aiResponse.split("\\n\\n");

        for (String block : taskBlocks) {
            String[] lines = block.split("\\n");
            String taskName = null;
            String taskDescription = null;

            for (String line : lines) {
                if (line.startsWith("Nom : ")) {
                    taskName = line.replace("Nom : ", "").trim();
                } else if (line.startsWith("Description : ")) {
                    taskDescription = line.replace("Description : ", "").trim();
                }
            }

            if (taskName != null && taskDescription != null) {
                // Ajout de valeurs par défaut
                String statut = "En attente"; // Tâche par défaut en attente
                String priorite = "Moyenne"; // Priorité par défaut
                Date dateLimite = new Date(); // Date limite par défaut (aujourd'hui)

                // Créer une tâche et l'ajouter à la liste
                tasks.add(new Tache(taskName, taskDescription, statut, dateLimite, evenement, fournisseur, priorite, "Aucun utilisateur associé"));
            }
        }

        return tasks;
    }
}
