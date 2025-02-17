package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModifierTache {

    @FXML
    private DatePicker dateLimitePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private ComboBox<?> fournisseurComboBox;

    @FXML
    private TextField nomField;

    @FXML
    private ComboBox<?> prioriteComboBox;

    @FXML
    private ComboBox<?> statutComboBox;

    @FXML
    private Button submitButton;

    @FXML
    private ComboBox<?> userAssocieComboBox;

    @FXML
    void RedirectBack(ActionEvent event) {

    }

}
