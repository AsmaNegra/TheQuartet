package utils;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GeoLocator {

    // ✅ Base de données des indicatifs téléphoniques par pays
    private static final Map<String, String> countryDialCodes = new HashMap<>();

    static {
        countryDialCodes.put("FR", "+33");  // France
        countryDialCodes.put("US", "+1");   // États-Unis
        countryDialCodes.put("CA", "+1");   // Canada
        countryDialCodes.put("DE", "+49");  // Allemagne
        countryDialCodes.put("TN", "+216"); // Tunisie
        countryDialCodes.put("IT", "+39");  // Italie
        countryDialCodes.put("GB", "+44");  // Royaume-Uni
        countryDialCodes.put("ES", "+34");  // Espagne
        countryDialCodes.put("MA", "+212"); // Maroc
        countryDialCodes.put("DZ", "+213"); // Algérie
        countryDialCodes.put("BE", "+32");  // Belgique
        countryDialCodes.put("CH", "+41");  // Suisse
        countryDialCodes.put("NL", "+31");  // Pays-Bas
    }

    /**
     * ✅ Récupère l'adresse IP publique de l'utilisateur.
     */
    public static String getPublicIP() {
        try {
            URL url = new URL("https://api64.ipify.org?format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = reader.readLine();
            reader.close();

            return new JSONObject(response).getString("ip");
        } catch (Exception e) {
            e.printStackTrace();
            return "IP inconnue";
        }
    }

    /**
     * ✅ Récupère le code pays à partir de l'adresse IP de l'utilisateur.
     */
    public static String getCountryCode() {
        try {
            String ip = getPublicIP();
            if (ip.equals("IP inconnue")) return "Pays inconnu";

            URL url = new URL("https://ipapi.co/" + ip + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonString = response.toString();
            System.out.println("📡 Réponse API : " + jsonString); // 🔍 Debugging

            // Vérification du format JSON avant de parser
            if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
                System.err.println("⚠ Erreur: Réponse invalide de l'API !");
                return "Pays inconnu";
            }

            JSONObject jsonResponse = new JSONObject(jsonString);
            return jsonResponse.optString("country_code", "Pays inconnu");
        } catch (Exception e) {
            e.printStackTrace();
            return "Pays inconnu";
        }
    }

    /**
     * ✅ Retourne l'indicatif téléphonique du pays de l'utilisateur.
     */
    public static String getDialCode() {
        String countryCode = getCountryCode();
        return countryDialCodes.getOrDefault(countryCode, "Indicatif inconnu");
    }

    public static void main(String[] args) {
        System.out.println("📍 Adresse IP : " + getPublicIP());
        System.out.println("🌍 Code pays : " + getCountryCode());
        System.out.println("📞 Indicatif téléphonique : " + getDialCode());
    }
}
