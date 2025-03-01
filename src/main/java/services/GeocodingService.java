package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class GeocodingService {

    private static final String NOMINATIM_API = "https://nominatim.openstreetmap.org/search";
    private static final String USER_AGENT = "JavaFX Event App"; // Identifier votre application

    /**
     * Convertit une adresse en coordonnées (latitude, longitude)
     * @param address Adresse à géocoder
     * @return Tableau avec [latitude, longitude] ou null si aucun résultat
     */
    public static double[] geocodeAddress(String address) {
        try {
            // Préparer l'URL de la requête
            String encodedAddress = URLEncoder.encode(address, "UTF-8");
            String urlString = NOMINATIM_API + "?q=" + encodedAddress + "&format=json&limit=1";

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurer la requête
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Obtenir le code de réponse
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lire la réponse
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parser la réponse JSON
                JSONArray jsonArray = new JSONArray(response.toString());

                // Vérifier si nous avons des résultats
                if (jsonArray.length() > 0) {
                    JSONObject firstResult = jsonArray.getJSONObject(0);

                    double lat = firstResult.getDouble("lat");
                    double lon = firstResult.getDouble("lon");

                    return new double[]{lat, lon};
                }
            } else {
                System.err.println("Erreur de géocodage: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Par défaut, retourner null
        return null;
    }

    // Cache mémoire pour stocker les résultats de géocodage
    private static final Map<String, double[]> geocodeCache = new HashMap<>();

    /**
     * Méthode avec mise en cache pour éviter trop de requêtes à l'API
     * @param address Adresse à géocoder
     * @return Tableau avec [latitude, longitude]
     */
    public static double[] geocodeAddressWithCache(String address) {
        if (address == null || address.trim().isEmpty()) {
            return null;
        }

        // Normaliser l'adresse
        String normalizedAddress = address.trim().toLowerCase();

        // Table de correspondance pour les lieux courants en Tunisie
        HashMap<String, double[]> locationMap = new HashMap<>();
        locationMap.put("tunis", new double[]{36.8, 10.18});
        locationMap.put("hammamet", new double[]{36.4, 10.62});
        locationMap.put("bizerte", new double[]{37.27, 9.87});
        locationMap.put("sousse", new double[]{35.83, 10.64});
        locationMap.put("monastir", new double[]{35.78, 10.83});
        locationMap.put("sfax", new double[]{34.74, 10.76});
        locationMap.put("tabarka", new double[]{36.95, 8.76});
        locationMap.put("la marsa", new double[]{36.88, 10.32});
        locationMap.put("carthage", new double[]{36.86, 10.33});
        locationMap.put("nabeul", new double[]{36.45, 10.73});
        locationMap.put("djerba", new double[]{33.80, 10.85});

        // Vérifier si l'adresse contient l'un des lieux connus
        for (String key : locationMap.keySet()) {
            if (normalizedAddress.contains(key)) {
                return locationMap.get(key);
            }
        }
        // Si pas dans le cache, faire la requête API
        try {
            // Limiter le débit des requêtes à l'API (max 1 requête par seconde)
            Thread.sleep(1000);

            double[] coordinates = geocodeAddress(normalizedAddress);

            // Stocker dans le cache si un résultat a été trouvé
            if (coordinates != null) {
                geocodeCache.put(normalizedAddress, coordinates);
            }

            return coordinates;
        } catch (Exception e) {
            // Si tout échoue, centrer sur Tunis par défaut
            System.out.println("Lieu non reconnu: " + address + " - centré sur Tunis par défaut");
            return new double[]{36.8, 10.18};
        }

    }


    // Pour respecter les conditions d'utilisation de Nominatim, il est recommandé de mettre en cache les résultats
    // et de limiter les requêtes à 1 par seconde


}
