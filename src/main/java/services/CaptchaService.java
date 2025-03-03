//package services;
//
//import org.json.JSONObject;
//import okhttp3.*;
//
//import java.io.IOException;
//import java.util.Random;
//
//public class CaptchaService {
//    private static final String API_URL = "https://hcaptcha.com/siteverify";
//    private static final String SITE_KEY = "VOTRE_SITE_KEY";
//    private static final String SECRET_KEY = "VOTRE_SECRET_KEY";
//
//    private String generatedCode;
//
//    // Génère un code CAPTCHA aléatoire (approche simple)
//    public String generateCaptchaCode() {
//        Random random = new Random();
//        int code = 100000 + random.nextInt(900000);  // Génère un nombre à 6 chiffres
//        generatedCode = String.valueOf(code);
//        return generatedCode;
//    }
//
//    // Vérifie si le code saisi correspond au code généré
//    public boolean verifyCaptcha(String userInput) {
//        return userInput != null && userInput.equals(generatedCode);
//    }
//
//    // Vérifie le token avec l'API hCaptcha
//    public boolean verifyWithAPI(String token) {
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("secret", SECRET_KEY)
//                .add("response", token)
//                .build();
//
//        Request request = new Request.Builder()
//                .url(API_URL)
//                .post(formBody)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) return false;
//
//            String responseBody = response.body().string();
//            JSONObject jsonResponse = new JSONObject(responseBody);
//
//            return jsonResponse.getBoolean("success");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}