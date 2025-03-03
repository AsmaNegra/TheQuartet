package utils;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import entities.Transaction;
import entities.Ticket;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;

public class MailjetSender {

    private static final String API_KEY = "a40375b537bfeb2790ff49d62c774b47";
    private static final String API_SECRET = "163aab5b1e56a1f65df76f82e5eed2be";
    private static final String FROM_EMAIL = "mariem.manai@esprit.tn";
    private static final String FROM_NAME = "Orchestra Support";

    public static void sendTransactionEmail(String recipientEmail, Transaction transaction, boolean reductionAppliquee) {
        try {
            if (recipientEmail == null || recipientEmail.isEmpty()) {
                System.err.println("❌ Email du destinataire manquant !");
                return;
            }

            MailjetClient client = new MailjetClient(API_KEY, API_SECRET);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String formattedDate = dateFormat.format(transaction.getDate_paiement());

            // 🎟️ Générer les détails du ticket acheté
            Ticket ticket = transaction.getTicket();
            String ticketDetails = "🎟 Ticket: " + ticket.getType() + "\n💰 Prix initial: " + ticket.getPrix() + " TND";

            // 🔹 Vérifier et afficher la réduction appliquée
            String reductionTexte = reductionAppliquee
                    ? "🎉 Vous avez bénéficié d'une réduction de 20% sur ce paiement !"
                    : "";
            String montantTexte = String.format("%.2f TND", transaction.getMontant_total());

            // 🔹 Générer un QR Code avec les détails JSON
            String qrData = "L'équipe Orchestra vous remercie pour votre confiance , et voici les détails de votre transaction :"
                    + "\"Statut\": \"" + transaction.getStatut() + "\","
                    + "\"Ticket\": \"" + ticket.getType() + "\","
                    + "\"Prix initial\": \"" + ticket.getPrix() + " TND\","
                    + "\"Montant payé\": \"" + montantTexte + "\",";


            // Générer et enregistrer le QR Code
            String qrFileName = "qr_" + transaction.getId_transaction() + ".png";
            String qrPath = QRCodeGenerator.generateQRCode(qrData, qrFileName);

            File qrFile = new File(qrPath);
            String qrBase64 = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(qrFile));

            // 📩 Contenu HTML de l'email avec QR Code
            String htmlContent = "<div style='background-color: #f8f9fa; padding: 20px; font-family: Arial, sans-serif; text-align: center;'>"
                    + "<div style='max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0,0,0,0.1);'>"
                    + "<h2 style='color: #003366;'>🎉 Paiement Confirmé 🎉</h2>"
                    + "<p>Merci pour votre achat ! Voici les détails de votre transaction :</p>"
                    + "<p><strong>💰 Montant Total :</strong> " + montantTexte + "</p>"
                    + (reductionAppliquee ? "<p style='color: green; font-weight: bold;'>" + reductionTexte + "</p>" : "")
                    + "<p><strong>💳 Mode de Paiement :</strong> " + transaction.getMode_paiement() + "</p>"
                    + "<p><strong>📅 Date de Paiement :</strong> " + formattedDate + "</p>"
                    + "<p><strong>🎟 Détails du ticket :</strong><br>" + ticketDetails.replace("\n", "<br>") + "</p>"
                    + "<p>🔍 Scannez ce QR Code pour voir votre transaction :</p>"
                    + "<img src='cid:qrCode' alt='QR Code' width='200' height='200' style='border:1px solid #ddd; padding:10px; background:white;'/>"
                    + "<p>Merci pour votre confiance !</p>"
                    + "</div>"
                    + "</div>";

            JSONArray attachments = new JSONArray()
                    .put(new JSONObject()
                            .put("ContentType", "image/png")
                            .put("Filename", "qrCode.png")
                            .put("Base64Content", qrBase64));
            JSONObject message = new JSONObject();
            message.put("From", new JSONObject().put("Email", FROM_EMAIL).put("Name", FROM_NAME));
            message.put("To", new JSONArray().put(new JSONObject().put("Email", recipientEmail).put("Name", "Client")));
            message.put("Subject", "✅ Confirmation de votre paiement - Orchestra 🎶");
            message.put("HTMLPart", htmlContent);
            message.put("Attachments", attachments);

            JSONArray messagesArray = new JSONArray().put(message);
            JSONObject requestBody = new JSONObject().put("Messages", messagesArray);

            com.mailjet.client.MailjetRequest request = new com.mailjet.client.MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, messagesArray);

            com.mailjet.client.MailjetResponse response = client.post(request);
            System.out.println(response.getStatus() == 200 ? "📨 Email envoyé avec succès !" : "❌ Erreur Mailjet : " + response.getData());

        } catch (MailjetException | IOException e) {
            System.err.println("❌ Erreur d'envoi d'email : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
