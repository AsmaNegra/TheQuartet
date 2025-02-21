package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class DetailsEvenement {

    @FXML
    private TextField resNom;

    @FXML
    private TextArea resDescription;

    @FXML
    private Label resDateDebut;

    @FXML
    private Label resDateFin;

    @FXML
    private TextField resLieu;

    @FXML
    private TextField resCategorie;

    @FXML
    private TextField resBudget;

    @FXML
    private ImageView resImageEvent;

    @FXML
    private TextField resNbPlaces;

    @FXML
    private Button evenementFermerButton;

    @FXML
    private ImageView detailImageView;

    @FXML
    private ImageView imageViewEvent;



    // Méthodes pour définir les valeurs des champs
    public void setResNom(String resNom) {
        this.resNom.setText(resNom);
    }

    public void setResDescription(String resDescription) {
        this.resDescription.setText(resDescription);
    }

    public void setResDateDebut(String resDateDebut) {
        this.resDateDebut.setText(resDateDebut);
    }

    public void setResDateFin(String resDateFin) {
        this.resDateFin.setText(resDateFin);
    }

    public void setResLieu(String resLieu) {
        this.resLieu.setText(resLieu);
    }

    public void setResCategorie(String resCategorie) {
        this.resCategorie.setText(resCategorie);
    }

    public void setResBudget(String resBudget) {
        this.resBudget.setText(resBudget);
    }

    public void setResImageEvent(String imagePath) {
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                String resourcePath = "/" + imagePath;
                Image image = new Image(getClass().getResource(resourcePath).toExternalForm());
                imageViewEvent.setImage(image);

                imageViewEvent.setFitWidth(200);
                imageViewEvent.setFitHeight(150);
                imageViewEvent.setPreserveRatio(true);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
            try {
                Image defaultImage = new Image(getClass().getResource("/images/default-event.png").toExternalForm());
                imageViewEvent.setImage(defaultImage);
            } catch (Exception ex) {
                System.err.println("Impossible de charger l'image par défaut");
            }
        }
    }


    public void setResNbPlaces(String resNbPlaces) {
        this.resNbPlaces.setText(resNbPlaces);
    }


}
