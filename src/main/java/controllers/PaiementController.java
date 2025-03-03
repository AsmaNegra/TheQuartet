package controllers;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import entities.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.ServiceTransaction;
import utils.MailjetSender;
import java.util.Locale;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PaiementController {

    @FXML private TextField amountField;
    @FXML private ComboBox<String> countryBox;
    @FXML private TextField cardNumberField, expirationField, cvcField,emailField;
    @FXML private Button payButton;
    @FXML private Label messageLabel;
    private final ServiceTransaction serviceTransaction = new ServiceTransaction();
    private Transaction transaction;

    @FXML
    public void initialize() {
        Stripe.apiKey = "sk_test_51QxnFtFjdr7TgGjOUSQ7gPVGOksd668QDZU3omt3fcgeIqXywZZ5Narvlc76wjH47ZoC2npwSXqbNMQqJJBo5qmR00CZvMOyXd";
        if (Stripe.apiKey == null || Stripe.apiKey.isEmpty()) {
            System.err.println("❌ ERREUR : Clé Stripe introuvable !");
        }
        countryBox.getItems().addAll("Tunisia", "France", "USA", "Germany", "UK");
        payButton.setOnAction(event -> processPayment());
    }

    private void processPayment() {
        if (!validateFields()) return;
        long amount = (long) (transaction.getMontant_total() * 100);

        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(amount)
                    .setCurrency("usd") // Changer en "eur" ou autre si besoin
                    .setDescription("Paiement sécurisé JavaFX")
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);
            serviceTransaction.marquerCommePayee(transaction.getId_transaction());
            messageLabel.setText("✅ Paiement réussi ! ID: " + intent.getId());

            // Vérification de la date de paiement
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
            String datePaiement = (transaction.getDate_paiement() != null)
                    ? dateFormat.format(transaction.getDate_paiement())
                    : "Date inconnue";

            // Envoyer l'email de confirmation via Mailjet
            MailjetSender.sendTransactionEmail(emailField.getText().trim(), transaction);

            messageLabel.setText("✅ Paiement réussi ! Un email de confirmation a été envoyé.");

        } catch (StripeException e) {
            messageLabel.setText("❌ Échec du paiement : " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur mise à jour transaction.");
            e.printStackTrace();
        } catch (Exception e) {
            messageLabel.setText("❌ Erreur lors de l'envoi de l'email.");
            e.printStackTrace();
        }
    }

    private boolean validateFields() {
        String cardNumber = cardNumberField.getText().replaceAll("\\s", "").trim();
        String expiration = expirationField.getText().trim();
        String cvc = cvcField.getText().trim();
        String country = countryBox.getValue();
        String recipientEmail = emailField.getText().trim();

        if (cardNumber.isEmpty() || expiration.isEmpty() || cvc.isEmpty() || country == null || recipientEmail.isEmpty()) {
            messageLabel.setText("⚠️ Veuillez remplir tous les champs.");
            return false;
        }

        if (!cardNumber.matches("\\d{13,19}")) {
            messageLabel.setText("❌ Numéro de carte invalide !");
            return false;
        }

        if (!expiration.matches("^(0[1-9]|1[0-2])/(\\d{2})$")) { // MM/YY
            messageLabel.setText("❌ Format de date invalide ! (MM/YY)");
            return false;
        }

        if (!cvc.matches("\\d{3,4}")) { // CVC à 3 ou 4 chiffres
            messageLabel.setText("❌ CVC invalide !");
            return false;
        }

        if (transaction == null) {
            messageLabel.setText("❌ Erreur : Aucune transaction reçue !");
            return false;
        }

        return true;
    }


//    private void processPayment() {
//        // Récupération des valeurs des champs
//        String cardNumber = cardNumberField.getText().replaceAll("\\s", "").trim(); // Supprime les espaces
//        String expiration = expirationField.getText().trim();
//        String cvc = cvcField.getText().trim();
//        String country = countryBox.getValue();
//
//        // Validation des entrées
//        if (cardNumber.isEmpty() || expiration.isEmpty() || cvc.isEmpty() || country == null) {
//            messageLabel.setText("⚠️ Veuillez remplir tous les champs.");
//            return;
//        }
//
//        if (!cardNumber.matches("\\d{13,19}")) { // Accepté : 13 à 19 chiffres
//            messageLabel.setText("❌ Numéro de carte invalide !");
//            return;
//        }
//
//        if (!expiration.matches("\\d{2}/\\d{2}")) {
//            messageLabel.setText("❌ Format de date invalide ! (MM/YY)");
//            return;
//        }
//
//        if (!cvc.matches("\\d{3,4}")) { // Certaines cartes (ex : Amex) ont un CVC à 4 chiffres
//            messageLabel.setText("❌ CVC invalide !");
//            return;
//        }
//
//        if (transaction == null) {
//            messageLabel.setText("❌ Erreur : Aucune transaction reçue !");
//            return;
//        }
//
//        // Récupération du montant
//        long amount = (long) (transaction.getMontant_total() * 100); // Converti en centimes
//
//        // Création d'un paiement Stripe
//        try {
//            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
//                    .setAmount(amount)
//                    .setCurrency("usd") // Changez en "eur" si nécessaire
//                    .setDescription("Paiement sécurisé JavaFX")
//                    .build();
//
//            PaymentIntent intent = PaymentIntent.create(params);
//            messageLabel.setText("✅ Paiement réussi ! ID: " + intent.getId());
//            serviceTransaction.marquerCommePayee(transaction.getId_transaction());
//        } catch (StripeException e) {
//            messageLabel.setText("❌ Échec du paiement : " + e.getMessage());
//            e.printStackTrace();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void setTransactionDetails(Transaction transaction) {
        if (transaction != null) {
            this.transaction = transaction;
            amountField.setText(String.format("%.2f TND", transaction.getMontant_total()));
        } else {
            messageLabel.setText("❌ Erreur : Aucune transaction reçue !");
        }
    }
}
