package utils;

import controllers.ConfigLoader;
import okhttp3.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AiUtility {
    private static final String API_KEY = ConfigLoader.getApiKey();
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;

    // Configuration du client HTTP avec des délais d'attente augmentés
    private static final OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build();

    /**
     * Génère une description d'événement en utilisant l'API Gemini
     */
    public static String generateEventDescription(String eventName, String category, String location) {
        // Construire le message de la requête
        String prompt = String.format(
            "Générez une description attrayante pour un événement nommé '%s' de catégorie '%s' qui se déroulera à '%s'. " +
                "La description doit être engageante, informative et adaptée à un public intéressé par ce type d'événement. " +
                "Limitez la description à environ 3-4 phrases. Évitez toute mention à l'IA ou à la génération de texte.",
            eventName, category, location
        );

        // Appel à l'API Gemini
        String response = callGeminiApi(prompt);
        return response != null ? response : "Pas de réponse de l'IA.";
    }

    /**
     * Vérifie si un commentaire contient des mots inappropriés
     * @param comment Le commentaire à vérifier
     * @return Un objet ModerationResult contenant le résultat de la vérification
     */
    public static ModerationResult moderateComment(String comment) {
        if (comment == null || comment.trim().isEmpty()) {
            return new ModerationResult(false, "", comment);
        }

        // Construire le message de la requête pour la modération
        String prompt = String.format(
            "Tu es un modérateur de contenu qui analyse les commentaires pour détecter du contenu inapproprié.\n\n" +
                "Commentaire à analyser: \"%s\"\n\n" +
                "Ta tâche est d'analyser le commentaire et de déterminer s'il contient du contenu inapproprié comme:\n" +
                "- Langage offensant ou grossier\n" +
                "- Propos haineux ou discriminatoires\n" +
                "- Contenus à caractère sexuel explicite\n" +
                "- Menaces ou incitation à la violence\n" +
                "- Autres types de contenu inapproprié\n\n" +
                "Réponds UNIQUEMENT au format JSON suivant sans aucun autre texte:\n" +
                "{\n" +
                "  \"inapproprie\": true/false,\n" +
                "  \"raison\": \"Explique pourquoi le commentaire est inapproprié (vide si approprié)\",\n" +
                "  \"commentaire_modere\": \"Version modérée du commentaire avec les mots inappropriés remplacés par des astérisques\"\n" +
                "}",
            comment
        );

        // Appel à l'API Gemini
        String response = callGeminiApi(prompt);

        if (response == null) {
            // En cas d'échec, retourner un résultat par défaut
            return new ModerationResult(false, "", comment);
        }

        try {
            // Extraire le JSON de la réponse (parfois Gemini peut ajouter du texte avant/après le JSON)
            String jsonStr = extractJsonFromResponse(response);
            JsonObject jsonObject = JsonParser.parseString(jsonStr).getAsJsonObject();

            boolean inapproprie = jsonObject.get("inapproprie").getAsBoolean();
            String raison = jsonObject.has("raison") ? jsonObject.get("raison").getAsString() : "";
            String commentaireModere = jsonObject.has("commentaire_modere") ?
                jsonObject.get("commentaire_modere").getAsString() : comment;

            return new ModerationResult(inapproprie, raison, commentaireModere);
        } catch (Exception e) {
            System.err.println("Erreur lors du parsing de la réponse de modération: " + e.getMessage());
            e.printStackTrace();
            // En cas d'erreur, retourner un résultat par défaut
            return new ModerationResult(false, "Erreur d'analyse", comment);
        }
    }

    /**
     * Extrait le JSON d'une réponse qui pourrait contenir du texte supplémentaire
     */
    private static String extractJsonFromResponse(String response) {
        // Chercher le début et la fin du JSON
        int start = response.indexOf("{");
        int end = response.lastIndexOf("}") + 1;

        if (start >= 0 && end > start) {
            return response.substring(start, end);
        }

        return "{}"; // JSON vide par défaut
    }

    /**
     * Appel générique à l'API Gemini
     */
    private static String callGeminiApi(String prompt) {
        // Construire le corps de la requête JSON
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

            if (!response.isSuccessful()) {
                System.err.println("Erreur API Gemini: " + response.code() + " - " + responseBody);
                return null;
            }

            // Extraire la réponse de l'IA
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonArray candidatesArray = jsonObject.getAsJsonArray("candidates");

            if (candidatesArray != null && candidatesArray.size() > 0) {
                JsonObject firstCandidate = candidatesArray.get(0).getAsJsonObject();
                JsonObject content = firstCandidate.getAsJsonObject("content");
                JsonArray partsArrayResponse = content.getAsJsonArray("parts");

                if (partsArrayResponse != null && partsArrayResponse.size() > 0) {
                    JsonObject firstPart = partsArrayResponse.get(0).getAsJsonObject();
                    return firstPart.get("text").getAsString();
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println("Erreur lors de l'appel à l'API Gemini: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Classe pour représenter le résultat de la modération
     */
    public static class ModerationResult {
        private final boolean inapproprie;
        private final String raison;
        private final String commentaireModere;

        public ModerationResult(boolean inapproprie, String raison, String commentaireModere) {
            this.inapproprie = inapproprie;
            this.raison = raison;
            this.commentaireModere = commentaireModere;
        }

        public boolean estInapproprie() {
            return inapproprie;
        }

        public String getRaison() {
            return raison;
        }

        public String getCommentaireModere() {
            return commentaireModere;
        }

        @Override
        public String toString() {
            return "ModerationResult{" +
                "inapproprie=" + inapproprie +
                ", raison='" + raison + '\'' +
                ", commentaireModere='" + commentaireModere + '\'' +
                '}';
        }
    }
}





//package utils;
//
//import controllers.ConfigLoader;
//import okhttp3.*;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//
//public class AiUtility {
//    private static final String API_KEY = ConfigLoader.getApiKey();
//    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;
//
//    public static String generateEventDescription(String eventName, String category, String location) {
//        OkHttpClient client = new OkHttpClient.Builder()
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .readTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(60, TimeUnit.SECONDS)
//            .build();
//
//        // Construire le message de la requête
//        String prompt = String.format(
//            "Générez une description attrayante pour un événement nommé '%s' de catégorie '%s' qui se déroulera à '%s'. " +
//                "La description doit être engageante, informative et adaptée à un public intéressé par ce type d'événement. " +
//                "Limitez la description à environ 3-4 phrases. Évitez toute mention à l'IA ou à la génération de texte.",
//            eventName, category, location
//        );
//
//        // Construire le corps de la requête JSON
//        JsonObject requestBody = new JsonObject();
//        JsonArray contentsArray = new JsonArray();
//        JsonObject contentObject = new JsonObject();
//        JsonArray partsArray = new JsonArray();
//        JsonObject textPart = new JsonObject();
//
//        textPart.addProperty("text", prompt);
//        partsArray.add(textPart);
//        contentObject.add("parts", partsArray);
//        contentsArray.add(contentObject);
//        requestBody.add("contents", contentsArray);
//
//        RequestBody body = RequestBody.create(requestBody.toString(), MediaType.get("application/json"));
//        Request request = new Request.Builder()
//            .url(API_URL)
//            .post(body)
//            .addHeader("Content-Type", "application/json")
//            .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            String responseBody = response.body().string();
//            System.out.println("HTTP Status Code: " + response.code());
//
//            // Extraire la réponse de l'IA
//            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
//            JsonArray candidatesArray = jsonObject.getAsJsonArray("candidates");
//
//            if (candidatesArray != null && candidatesArray.size() > 0) {
//                JsonObject firstCandidate = candidatesArray.get(0).getAsJsonObject();
//                JsonObject content = firstCandidate.getAsJsonObject("content");
//                JsonArray partsArrayResponse = content.getAsJsonArray("parts");
//
//                if (partsArrayResponse != null && partsArrayResponse.size() > 0) {
//                    JsonObject firstPart = partsArrayResponse.get(0).getAsJsonObject();
//                    return firstPart.get("text").getAsString();
//                }
//            }
//            return "Pas de réponse de l'IA.";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Une erreur s'est produite: " + e.getMessage();
//        }
//    }
//}
