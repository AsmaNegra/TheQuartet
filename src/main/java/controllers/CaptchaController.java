//package controllers;
//
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import services.CaptchaService;
//
//import java.net.URL;
//import java.util.Random;
//import java.util.ResourceBundle;
//
//public class CaptchaController implements Initializable {
//
//    @FXML
//    private AnchorPane captchaPane;
//
//    @FXML
//    private Canvas captchaCanvas;
//
//    @FXML
//    private TextField captchaField;
//
//    private CaptchaService captchaService;
//    private String currentCaptchaCode;
//    private Random random = new Random();
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        captchaService = new CaptchaService();
//        refreshCaptcha();
//    }
//
//    @FXML
//    public void refreshCaptcha() {
//        // Générer un nouveau code CAPTCHA
//        currentCaptchaCode = captchaService.generateCaptchaCode();
//
//        // Dessiner le CAPTCHA sur le canvas
//        GraphicsContext gc = captchaCanvas.getGraphicsContext2D();
//        drawCaptcha(gc, currentCaptchaCode);
//    }
//
//    private void drawCaptcha(GraphicsContext gc, String code) {
//        double width = captchaCanvas.getWidth();
//        double height = captchaCanvas.getHeight();
//
//        // Effacer le canvas
//        gc.clearRect(0, 0, width, height);
//
//        // Dessiner un fond avec des lignes aléatoires
//        gc.setFill(Color.WHITE);
//        gc.fillRect(0, 0, width, height);
//
//        // Ajouter des lignes de fond pour la distorsion
//        gc.setStroke(Color.LIGHTGRAY);
//        for (int i = 0; i < 10; i++) {
//            double x1 = random.nextDouble() * width;
//            double y1 = random.nextDouble() * height;
//            double x2 = random.nextDouble() * width;
//            double y2 = random.nextDouble() * height;
//            gc.strokeLine(x1, y1, x2, y2);
//        }
//
//        // Dessiner le texte avec une police aléatoire et une couleur aléatoire
//        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
//
//        double startX = 20;
//        for (int i = 0; i < code.length(); i++) {
//            // Couleur aléatoire pour chaque caractère
//            gc.setFill(getRandomColor());
//
//            // Angle légèrement aléatoire
//            double angle = random.nextDouble() * 30 - 15; // -15 à +15 degrés
//
//            // Position du caractère
//            double x = startX + i * 35 + random.nextDouble() * 5;
//            double y = height / 2 + 10 + random.nextDouble() * 10 - 5;
//
//            // Sauvegarder l'état actuel
//            gc.save();
//
//            // Appliquer la rotation
//            gc.translate(x, y);
//            gc.rotate(angle);
//
//            // Dessiner le caractère
//            gc.fillText(String.valueOf(code.charAt(i)), 0, 0);
//
//            // Restaurer l'état
//            gc.restore();
//        }
//
//        // Ajouter des points aléatoires pour la distorsion
//        gc.setFill(Color.DARKGRAY);
//        for (int i = 0; i < 100; i++) {
//            double x = random.nextDouble() * width;
//            double y = random.nextDouble() * height;
//            gc.fillOval(x, y, 2, 2);
//        }
//    }
//
//    private Color getRandomColor() {
//        return Color.rgb(
//                random.nextInt(100),
//                random.nextInt(100),
//                random.nextInt(100)
//        );
//    }
//
//    // Méthode pour vérifier si le code saisi est correct
//    public boolean validateCaptcha() {
//        String userInput = captchaField.getText();
//        return captchaService.verifyCaptcha(userInput);
//    }
//
//    // Méthode pour réinitialiser le champ de texte
//    public void resetField() {
//        captchaField.clear();
//    }
//}