package utils; // Assurez-vous que le package est correct

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecaptchaVerifier {

    private static final String SECRET_KEY = "VOTRE_CLE_SECRETE_RECAPTCHA"; // Remplacez par votre clé secrète

    /**
     * Vérifie la réponse reCAPTCHA avec l'API Google.
     *
     * @param gRecaptchaResponse La réponse reCAPTCHA envoyée par le client.
     * @return true si la vérification est réussie, false sinon.
     * @throws IOException En cas d'erreur de communication avec l'API.
     */
    public static boolean verify(String gRecaptchaResponse) throws IOException {
        if (gRecaptchaResponse == null || gRecaptchaResponse.isEmpty()) {
            return false;
        }

        // URL de l'API Google reCAPTCHA
        String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + SECRET_KEY + "&response=" + gRecaptchaResponse;

        // Ouvrir une connexion HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        // Lire la réponse
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Analyser la réponse JSON
        System.out.println("Réponse reCAPTCHA: " + response.toString());
        return response.toString().contains("\"success\": true");
    }
}