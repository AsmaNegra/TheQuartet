package services;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class EmailService {

    private static final String API_KEY = "e260ecf6adb799a75731bdc42a412b21";
    private static final String SECRET_KEY = "2b7a903e8de881a82d5046156dca9a97";

    // Génère un code de vérification à 6 chiffres
    public static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Génère un nombre entre 100000 et 999999
        return String.valueOf(code);
    }

    // Envoie un email avec le code de vérification
    public static boolean sendVerificationEmail(String recipientEmail, String verificationCode) {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;

        ClientOptions options = ClientOptions.builder()
                .apiKey(API_KEY)
                .apiSecretKey(SECRET_KEY)
                .build();

        client = new MailjetClient(options);

        JSONObject message = new JSONObject()
                .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", "rima.benhajali@esprit.tn")
                        .put("Name", "Orchestra"))
                .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                                .put("Email", recipientEmail)))
                .put(Emailv31.Message.SUBJECT, "Code de vérification")
                .put(Emailv31.Message.TEXTPART, "Votre code de vérification est: " + verificationCode)
                .put(Emailv31.Message.HTMLPART, "<h3>Vérification de votre compte</h3><p>Votre code de vérification est: <strong>" + verificationCode + "</strong></p>");

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(message));

        try {
            response = client.post(request);
            System.out.println("Status: " + response.getStatus());
            System.out.println("Data: " + response.getData());
            return response.getStatus() == 200;
        } catch (MailjetException e) {
            e.printStackTrace();
            return false;
        }
    }
}