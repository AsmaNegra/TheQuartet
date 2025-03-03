package controllers;

import entities.Evenement;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import services.ServiceEvenement;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class MapController {

    @FXML
    private VBox mapContainer;

    private WebView webView;
    private WebEngine webEngine;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();

    public void initialize() {
        // Créer WebView
        webView = new WebView();
        webEngine = webView.getEngine();

        // Ajouter WebView au container
        mapContainer.getChildren().add(webView);

        // Charger la page HTML avec la carte
        String url = getClass().getResource("/map.html").toExternalForm();
        webEngine.load(url);

        // Attendre que la page soit chargée pour initialiser la communication Java <-> JavaScript
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == javafx.concurrent.Worker.State.SUCCEEDED) {
                initJSBridge();
            }
        });
    }

    private void initJSBridge() {
        // Créer un pont entre Java et JavaScript
        JSObject window = (JSObject) webEngine.executeScript("window");
        window.setMember("javaConnector", new JavaConnector());

        // Charger les événements sur la carte
        loadEventsOnMap();
    }

    private void loadEventsOnMap() {
        try {
            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                // Convertir l'adresse en coordonnées (geocoding)
                // Ici nous utilisons une méthode simplifiée, vous devrez implémenter un vrai géocodage
                double[] coordinates = geocodeAddress(event.getLieu());

                if (coordinates != null) {
                    // Ajouter le marqueur sur la carte via JavaScript
                    webEngine.executeScript(String.format(
                        "addMarker(%f, %f, '%s', '%s', '%s')",
                        coordinates[0], coordinates[1],
                        event.getNom().replace("'", "\\'"),
                        event.getLieu().replace("'", "\\'"),
                        event.getCategorie().replace("'", "\\'")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode simplifiée de géocodage - à remplacer par un vrai service de géocodage
    private double[] geocodeAddress(String address) {
        // Cette méthode simulée doit être remplacée par un vrai géocodage
        // Utiliser OpenStreetMap Nominatim API ou autre service

        // Exemple de retour simulé pour Paris
        if (address.toLowerCase().contains("paris")) {
            return new double[]{48.8566, 2.3522};
        }
        // Exemple pour Lyon
        else if (address.toLowerCase().contains("lyon")) {
            return new double[]{45.7640, 4.8357};
        }
        // Valeur par défaut (à remplacer)
        return new double[]{46.227638, 2.213749}; // Centre de la France
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
                        // Ici, vous pouvez afficher les détails de l'événement
                        System.out.println("Événement sélectionné: " + event.getNom());
                        // Vous pourriez ouvrir une fenêtre modale ou naviguer vers la page de détails
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour filtrer les événements par catégorie sur la carte
    public void filterEventsByCategory(String category) {
        webEngine.executeScript("clearMarkers()");

        try {
            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (category.equals("Tous") || event.getCategorie().equals(category)) {
                    double[] coordinates = geocodeAddress(event.getLieu());

                    if (coordinates != null) {
                        webEngine.executeScript(String.format(
                            "addMarker(%f, %f, '%s', '%s', '%s')",
                            coordinates[0], coordinates[1],
                            event.getNom().replace("'", "\\'"),
                            event.getLieu().replace("'", "\\'"),
                            event.getCategorie().replace("'", "\\'")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
