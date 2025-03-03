package controllers;

import entities.Evenement;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import services.ServiceEvenement;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class SidebarMapController {

    private VBox mapContainer;
    private WebView webView;
    private WebEngine webEngine;
    private ServiceEvenement serviceEvenement;

    public SidebarMapController(VBox mapContainer, ServiceEvenement serviceEvenement) {
        this.mapContainer = mapContainer;
        this.serviceEvenement = serviceEvenement;
        initialize();
    }

    private void initialize() {
        // Créer WebView
        webView = new WebView();
        webEngine = webView.getEngine();

        // Ajouter WebView au container
        mapContainer.getChildren().clear();
        mapContainer.getChildren().add(webView);

        // Charger la page HTML avec la carte
        URL url = getClass().getResource("/mapSideBar.html");
        if (url != null) {
            String urlStr = url.toExternalForm();
            webEngine.load(urlStr);

            // Attendre que la page soit chargée pour initialiser la communication Java <-> JavaScript
            webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                    initJSBridge();
                }
            });
        } else {
            System.err.println("Impossible de trouver le fichier mapSideBar.html");
        }
    }

    private void initJSBridge() {
        // Créer un pont entre Java et JavaScript
        JSObject window = (JSObject) webEngine.executeScript("window");
        window.setMember("javaConnector", new JavaConnector());

        // Charger les événements sur la carte
        loadEventsOnMap();
    }

    public void loadEventsOnMap() {
        try {
            webEngine.executeScript("if(typeof clearMarkers === 'function') clearMarkers();");

            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                // Nous utilisons directement l'adresse pour le géocodage via l'API Google Maps
                String location = event.getLieu();
                if (location != null && !location.isEmpty()) {
                    // Échapper les caractères spéciaux pour JavaScript
                    String escapedName = escapeJavaScriptString(event.getNom());
                    String escapedLocation = escapeJavaScriptString(location);
                    String escapedCategory = escapeJavaScriptString(event.getCategorie());

                    // Exécuter la recherche d'adresse et l'ajout de marqueur
                    webEngine.executeScript(
                        "if(typeof searchAndAddMarker === 'function') " +
                            "searchAndAddMarker('" + escapedLocation + "', '" +
                            escapedName + "', '" + escapedCategory + "');"
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String escapeJavaScriptString(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
            .replace("'", "\\'")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r");
    }

    // Méthode pour filtrer les événements par catégorie sur la carte
    public void filterEventsByCategory(String category) {
        try {
            webEngine.executeScript("if(typeof clearMarkers === 'function') clearMarkers();");

            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (category.equals("Tous") || event.getCategorie().equals(category)) {
                    String location = event.getLieu();
                    if (location != null && !location.isEmpty()) {
                        String escapedName = escapeJavaScriptString(event.getNom());
                        String escapedLocation = escapeJavaScriptString(location);
                        String escapedCategory = escapeJavaScriptString(event.getCategorie());

                        webEngine.executeScript(
                            "if(typeof searchAndAddMarker === 'function') " +
                                "searchAndAddMarker('" + escapedLocation + "', '" +
                                escapedName + "', '" + escapedCategory + "');"
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Classe pour établir le pont entre Java et JavaScript
    public class JavaConnector {
        // Méthode appelée depuis JavaScript quand un marqueur est cliqué
        public void showEventDetails(String eventName) {
            try {
                // Trouver l'événement correspondant
                List<Evenement> evenements = serviceEvenement.afficher();
                for (Evenement event : evenements) {
                    if (event.getNom().equals(eventName)) {
                        // Ici, vous pourriez ajouter du code pour afficher les détails de l'événement
                        System.out.println("Événement sélectionné sur la carte: " + event.getNom());
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
