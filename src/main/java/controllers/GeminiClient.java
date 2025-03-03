package controllers;

import okhttp3.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Tache;
import entities.Evenement;
import entities.Fournisseur;
import utils.PDFUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                tasks.add(new Tache(taskName, taskDescription, statut, dateLimite, evenement, fournisseur, priorite, "Aucun utilisateur associé",0));
            }
        }

        return tasks;
    }




    public static String determineExpirationDate(File pdfFile) {
        // Extraire le texte complet du PDF
        String contractText = PDFUtils.extractTextFromPDF(pdfFile);

        // Vérifier si le texte a été correctement extrait
        if (contractText.isEmpty()) {
            System.out.println("❌ Erreur : Impossible d'extraire le texte du PDF.");
            return "Erreur : Extraction échouée";
        }

        // Obtenir la date actuelle (date de signature du contrat)
        LocalDate currentDate = LocalDate.now();

        // Créer le prompt pour l'API Gemini (en demandant **uniquement** la date d'expiration)
        String prompt = "Voici le texte complet d'un contrat signé le " + currentDate + " :\n\n"
                + contractText
                + "\n\nTrouve uniquement la date exacte d'expiration du contrat et renvoie-la sous le format suivant :\n"
                + "DATE EXPIRATION : JJ/MM/AA\n"
                + "Si aucune date d'expiration n'est trouvée, écris seulement : 'DATE EXPIRATION : null'";

        // Construire la requête JSON
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

        // Configurer le client HTTP
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        // Construire la requête HTTP
        Request request = new Request.Builder()
                .url(API_URL)
                .post(RequestBody.create(requestBody.toString(), MediaType.get("application/json")))
                .addHeader("Content-Type", "application/json")
                .build();

        // Envoyer la requête et traiter la réponse
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("❌ Erreur : Réponse non réussie de l'API. Code : " + response.code());
                System.out.println("🔍 Réponse de l'API : " + response.body().string());
                return "Erreur API";
            }

            // Lire la réponse de l'API
            String responseBody = response.body().string();

            // Extraire la réponse textuelle
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonArray candidatesArray = jsonResponse.getAsJsonArray("candidates");

            if (candidatesArray != null && candidatesArray.size() > 0) {
                JsonObject firstCandidate = candidatesArray.get(0).getAsJsonObject();
                JsonObject content = firstCandidate.getAsJsonObject("content");
                JsonArray partsArrayResponse = content.getAsJsonArray("parts");

                if (partsArrayResponse != null && partsArrayResponse.size() > 0) {
                    JsonObject firstPart = partsArrayResponse.get(0).getAsJsonObject();
                    String extractedText = firstPart.get("text").getAsString().trim();

                    // Vérifier si la réponse contient "DATE EXPIRATION : null"
                    if (extractedText.contains("DATE EXPIRATION : null")) {
                        return "Pas de date d'expiration!";
                    }

                    // Extraire la date en JJ/MM/AA
                    Pattern pattern = Pattern.compile("DATE EXPIRATION : (\\d{2}/\\d{2}/\\d{2})");
                    Matcher matcher = pattern.matcher(extractedText);

                    if (matcher.find()) {
                        String extractedDate = matcher.group(1);
                        System.out.println("📅 Date extraite : " + extractedDate);

                        // Convertir en LocalDate
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                        LocalDate expirationDate = LocalDate.parse(extractedDate, formatter);

                        // Vérifier si le contrat est expiré
                        if (expirationDate.isAfter(currentDate)) {
                            return "Contrat valide jusqu'au " + expirationDate;
                        } else {
                            return "Contrat expiré";
                        }
                    }
                }
            }

            return "⚠ Impossible d'extraire la date d'expiration.";
        } catch (IOException e) {
            e.printStackTrace();
            return "❌ Erreur de connexion API";
        }
    }
    public static String determineExpirationDateFromText(String contractText) {
        if (contractText == null || contractText.trim().isEmpty()) {
            return "Erreur : Texte du contrat vide.";
        }

        // Obtenir la date actuelle
        LocalDate currentDate = LocalDate.now();

        // 🔹 Regex pour détecter les dates dans différents formats (JJ/MM/AAAA, JJ-MM-AAAA, JJ/MM/AA, JJ-MM-AA)
        Pattern datePattern = Pattern.compile("(\\d{2})[/-](\\d{2})[/-](\\d{2,4})");
        Matcher matcher = datePattern.matcher(contractText);

        while (matcher.find()) {
            try {
                // Extraire la date détectée
                String rawDate = matcher.group();
                System.out.println("📅 Date détectée : " + rawDate);

                // Remplacer les séparateurs `-` par `/` pour standardiser
                rawDate = rawDate.replace("-", "/");

                // Déterminer le format correct en fonction de la longueur de l'année
                DateTimeFormatter formatter;
                String[] dateParts = rawDate.split("/");
                String year = dateParts[2];

                if (year.length() == 2) {
                    // Si l’année est sur 2 chiffres, utiliser `yy`
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                } else {
                    // Si l’année est sur 4 chiffres, utiliser `yyyy`
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                }

                // Convertir la date en LocalDate
                LocalDate expirationDate = LocalDate.parse(rawDate, formatter);

                // Vérifier si la date est dans le futur
                if (expirationDate.isAfter(currentDate)) {
                    return "Contrat valide jusqu'au " + expirationDate;
                } else {
                    return "Contrat expiré";
                }

            } catch (DateTimeParseException e) {
                System.out.println("❌ Erreur de conversion de la date : " + matcher.group());
            }
        }

        return "⚠ Aucune date valide trouvée dans le texte.";
    }

}

