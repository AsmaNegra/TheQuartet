package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ResourceBundle;

public class TestMapController implements Initializable {
    @FXML
    private VBox mapContainer;

    private WebView webView;
    private WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Ajouter au début de votre méthode main ou initialize
        try {
            Class.forName("javafx.scene.web.WebView");
            System.out.println("WebView class found in classpath");
        } catch (ClassNotFoundException e) {
            System.err.println("WebView class NOT found in classpath");
        }
        System.out.println("Test initialize");
        initMap();
    }

    private void initMap() {
        // Assurez-vous que le mapContainer a une hauteur suffisante
        mapContainer.setMinHeight(500);
        mapContainer.setPrefHeight(500);

        webView = new WebView();
        webEngine = webView.getEngine();

        // Assurez-vous que le WebView remplit tout l'espace disponible
        webView.setPrefHeight(500);
        webView.setPrefWidth(800);

        mapContainer.getChildren().add(webView);


        // D'abord configurer l'écouteur d'état AVANT de charger le contenu
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            System.out.println("État du chargement: " + newState);

            // Dans votre écouteur d'état
            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                System.out.println("Page chargée avec succès");

                try {
                    // Initialiser la carte directement via JavaScript après chargement
                    webEngine.executeScript(
                            "var map = L.map('map').setView([46.227638, 2.213749], 5);" +
                                    "L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {" +
                                    "    attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'" +
                                    "}).addTo(map);" +
                                    "L.marker([48.8566, 2.3522]).addTo(map)" +
                                    "    .bindPopup('<b>Paris</b><br>La ville lumière')" +
                                    "    .openPopup();"
                    );

                    // Créer un pont Java-JavaScript
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("javaConnector", new JavaConnector());

                    System.out.println("Script JavaScript exécuté");
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'exécution JavaScript: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        // Charger une carte Leaflet basique
        String leafletHtml =
                "<html>" +
                        "<head>" +
                        "    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.css\" />" +
                        "    <script src=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.js\"></script>" +
                        "    <style>" +
                        "        html, body { height: 100%; margin: 0; padding: 0; }" +
                        "        #map { position: absolute; top: 0; bottom: 0; width: 100%; height: 100%; }" +
                        "    </style>" +
                        "</head>" +
                        "<body>" +
                        "    <div id=\"map\"></div>" +
                        "    <script>" +
                        "        window.onload = function() {" +
                        "            console.log('Window loaded');" +
                        "            var map = L.map('map').setView([46.227638, 2.213749], 5);" +
                        "            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {" +
                        "                attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'" +
                        "            }).addTo(map);" +
                        "            // Ajouter un marqueur test" +
                        "            L.marker([48.8566, 2.3522]).addTo(map)" +
                        "                .bindPopup('<b>Paris</b><br>La ville lumière')" +
                        "                .openPopup();" +
                        "            console.log('Carte initialisée');" +
                        "            if (window.javaConnector) {" +
                        "                javaConnector.logMessage('Carte Leaflet initialisée');" +
                        "            }" +
                        "        };" +
                        "    </script>" +
                        "</body>" +
                        "</html>";

        System.out.println("Chargement du contenu HTML");
        webEngine.loadContent(leafletHtml);
    }
    // Classe pour communiquer avec JavaScript
    public class JavaConnector {
        public void logMessage(String message) {
            System.out.println("Message reçu de JavaScript: " + message);
        }
    }
}
