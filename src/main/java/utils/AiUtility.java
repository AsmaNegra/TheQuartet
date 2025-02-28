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

    public static String generateEventDescription(String eventName, String category, String location) {
        OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

        // Construire le message de la requête
        String prompt = String.format(
            "Générez une description attrayante pour un événement nommé '%s' de catégorie '%s' qui se déroulera à '%s'. " +
                "La description doit être engageante, informative et adaptée à un public intéressé par ce type d'événement. " +
                "Limitez la description à environ 3-4 phrases. Évitez toute mention à l'IA ou à la génération de texte.",
            eventName, category, location
        );

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
            System.out.println("HTTP Status Code: " + response.code());

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
            return "Pas de réponse de l'IA.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Une erreur s'est produite: " + e.getMessage();
        }
    }
}




//package utils;
//
//import com.theokanning.openai.completion.chat.ChatCompletionRequest;
//import com.theokanning.openai.completion.chat.ChatMessage;
//import com.theokanning.openai.service.OpenAiService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AiUtility {
////    private static final String API_KEY = "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";
//private static final String API_KEY = "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";
//
//    public static String generateEventDescription(String eventName, String category, String location) {
//        OpenAiService service = new OpenAiService(API_KEY);
//
//        List<ChatMessage> messages = new ArrayList<>();
//        messages.add(new ChatMessage("system", "Vous êtes un assistant qui aide à créer des descriptions d'événements attrayantes et professionnelles."));
//
//        String userPrompt = String.format(
//            "Générez une description attrayante pour un événement nommé '%s' de catégorie '%s' qui se déroulera à '%s'. " +
//                "La description doit être engageante, informative et adaptée à un public intéressé par ce type d'événement. " +
//                "Limitez la description à environ 3-4 phrases. Évitez toute mention à l'IA ou à la génération de texte.",
//            eventName, category, location
//        );
//
//        messages.add(new ChatMessage("user", userPrompt));
//
//        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
//            .model("gpt-3.5-turbo")
//            .messages(messages)
//            .maxTokens(200)
//            .build();
//
//        try {
//            String response = service.createChatCompletion(completionRequest)
//                .getChoices().get(0).getMessage().getContent();
//            return response;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Une erreur s'est produite: " + e.getMessage();
//        }
//    }
//}
