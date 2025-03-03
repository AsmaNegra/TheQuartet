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

    @FXML private Label amountLabel;
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
        serviceTransaction.marquerCommePayee(transaction.getId_transaction());
        transaction.setStatut("Payée");
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency("usd")
                .setDescription("Paiement sécurisé JavaFX")
                .build();

        PaymentIntent intent = PaymentIntent.create(params);
        messageLabel.setText("✅ Paiement réussi ! ID: " + intent.getId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
        String datePaiement = (transaction.getDate_paiement() != null)
                ? dateFormat.format(transaction.getDate_paiement())
                : "Date inconnue";
        boolean reductionAppliquee = (serviceTransaction.compterTransactionsPayees(transaction.getUtilisateur_id().getUtilisateurId()) + 1) % 4 == 0;
        MailjetSender.sendTransactionEmail(emailField.getText().trim(), transaction, reductionAppliquee);
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
    public void setTransactionDetails(Transaction transaction, boolean reductionAppliquee) {
        if (transaction != null) {
            this.transaction = transaction;
            double montantFinal = transaction.getMontant_total();
            amountLabel.setText(String.format("%.2f TND %s",
                    montantFinal,
                    reductionAppliquee ? "📉 (20% de Réduction appliquée !)" : ""));
        } else {
            messageLabel.setText("❌ Erreur : Aucune transaction reçue !");
        }
    }


}