package controllers;

import entities.Fournisseur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceFournisseur;
import utils.GeoLocator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AjoutFournisseur {

    @FXML
    private TextField nomField, numTelField;

    @FXML
    private Text EtatContrat;
    @FXML
    private ComboBox<String> typeServiceComboBox;

    private final ServiceFournisseur serviceFournisseur = new ServiceFournisseur();

    @FXML
    private Button uploadButton, btnSitemap, btnGift, btnHome, btnHome1, btnLogout;

    @FXML
    private Label fileLabel, labelUser;

    @FXML
    private AnchorPane sidebar;

    private File selectedFile;
    private String indicatifPays;
    @FXML
    private Label indicatifLabel;
    // 📌 Base des longueurs de numéros valides par pays
    private static final Map<String, Integer> numLengthByCountry = new HashMap<>();

    static {
        numLengthByCountry.put("+33", 9);  // France
        numLengthByCountry.put("+1", 10);  // USA, Canada
        numLengthByCountry.put("+49", 10); // Allemagne
        numLengthByCountry.put("+216", 8); // Tunisie
        numLengthByCountry.put("+39", 10); // Italie
        numLengthByCountry.put("+44", 10); // Royaume-Uni
        numLengthByCountry.put("+34", 9);  // Espagne
        numLengthByCountry.put("+212", 9); // Maroc
        numLengthByCountry.put("+213", 9); // Algérie
        numLengthByCountry.put("+32", 9);  // Belgique
        numLengthByCountry.put("+41", 9);  // Suisse
        numLengthByCountry.put("+31", 9);  // Pays-Bas
    }

    public void initialize() {
        indicatifPays = GeoLocator.getDialCode();
        indicatifLabel.setText( indicatifPays);
        }

    private boolean validatePhoneNumber() {
        String phone = numTelField.getText();
        if (!phone.matches("\\d+")) {
            showAlert("Numéro invalide", "Le numéro doit contenir uniquement des chiffres.");
            return false;
        }

        int expectedLength = numLengthByCountry.getOrDefault(indicatifPays, 8);
        if (phone.length() != expectedLength) {
            showAlert("Longueur incorrecte", "Le numéro doit contenir " + expectedLength + " chiffres.");
            return false;
        }

        return true;
    }

    @FXML
    void expandSidebar(MouseEvent event) {
        Timeline expandTimeline = new Timeline();
        expandTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 200)));
        expandTimeline.play();
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
        btnLogout.setText("Logout");
        labelUser.setVisible(true);
    }

    @FXML
    void collapseSidebar(MouseEvent event) {
        Timeline collapseTimeline = new Timeline();
        collapseTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 70)));
        collapseTimeline.play();
        btnSitemap.setText("");
        btnGift.setText("");
        btnHome.setText("");
        btnHome1.setText("");
        btnLogout.setText("");
        labelUser.setVisible(false);
    }

    @FXML
    void RedirectBack(ActionEvent event) {
        redirectToPage(event, "/AdminFournisseur.fxml");
    }

    @FXML
    void handleGiftClick(ActionEvent event) {
        redirectToPage(event, "/AdminFournisseur.fxml");
    }

    @FXML
    void handleHomeClick(ActionEvent event) {
        redirectToPage(event, "/ViewAllEvents.fxml");
    }

    @FXML
    void handleSitemapClick(ActionEvent event) {
        redirectToPage(event, "/EventOrganisation.fxml");
    }

    private void redirectToPage(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        try {
            if (!validateInput()) {
                return;
            }

            if (selectedFile == null) {
                showAlert("Fichier manquant", "Veuillez sélectionner un fichier de contrat.");
                return;
            }

            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setNom(nomField.getText());
            fournisseur.setTypeService(typeServiceComboBox.getValue());
            fournisseur.setNum_tel(numTelField.getText());

            GeminiClient client = new GeminiClient();
            String etatContrat;

            if (selectedFile.getName().endsWith(".pdf")) {
                etatContrat = client.determineExpirationDate(selectedFile);
            } else if (selectedFile.getName().endsWith(".png") || selectedFile.getName().endsWith(".jpg") || selectedFile.getName().endsWith(".jpeg")) {
                String textContrat = OCRProcessor.extractTextFromImage(selectedFile.getAbsolutePath());
                etatContrat = client.determineExpirationDateFromText(textContrat);
            } else {
                etatContrat = "Format de fichier non supporté.";
            }

            EtatContrat.setText(etatContrat);
            fournisseur.setContrat(etatContrat);
            System.out.println("📅 État du contrat extrait: " + etatContrat);

            serviceFournisseur.ajouter(fournisseur);
            System.out.println("✅ Fournisseur ajouté avec succès !");
            redirectToPage(event, "/AdminFournisseur.fxml");

        } catch (SQLException e) {
            showAlert("Erreur", "Une erreur est survenue lors de l'ajout du fournisseur.");
        }
    }

    private boolean validateInput() {
        if (nomField.getText().isEmpty()) {
            showAlert("Champ vide", "Le champ Nom ne peut pas être vide.");
            return false;
        }
        if (typeServiceComboBox.getValue() == null) {
            showAlert("Sélection requise", "Veuillez sélectionner un type de service.");
            return false;
        }
        if (!numTelField.getText().matches("\\d{8,15}")) {
            showAlert("Numéro invalide", "Le numéro de téléphone doit contenir uniquement des chiffres et avoir une longueur valide (8-15 caractères).");
            return false;
        }
        if (!validatePhoneNumber()) return false;

        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleFileUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier de contrat");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(uploadButton.getScene().getWindow());
        if (file != null) {
            selectedFile = file;
            fileLabel.setText("Fichier : " + file.getName());

            GeminiClient client = new GeminiClient();
            String etatContrat;

            if (file.getName().endsWith(".pdf")) {
                // 🔹 PDF → Analyse avec `determineExpirationDate()`
                etatContrat = client.determineExpirationDate(file);
            } else if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
                // 🔹 Image → OCR puis analyse du texte avec `determineExpirationDateFromText()`
                String textContrat = OCRProcessor.extractTextFromImage(file.getAbsolutePath());
                etatContrat = client.determineExpirationDateFromText(textContrat);
            } else {
                etatContrat = "Format de fichier non supporté.";
            }

            EtatContrat.setText(etatContrat);
        }
    }

}
