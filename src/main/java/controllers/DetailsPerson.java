package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DetailsPerson {

    @FXML
    private TextField resNom;

    @FXML
    private TextField resPrenom;

    public void setResNom(String resNom) {
        this.resNom.setText(resNom);
    }

    public void setResPrenom(String resPrenom) {
        this.resPrenom.setText(resPrenom);
    }
}
