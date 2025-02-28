package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Testcontroller {

    @FXML
    private TextField inputField; // For user input

    @FXML
    private TextArea outputArea; // For displaying the API response

    private static final String API_KEY = "sk-624447c2df434e229ac41767b3af10e4";
    private static final String API_URL = "https://api.deepseek.com/v1/chat/free"; // Replace with the actual endpoint


}