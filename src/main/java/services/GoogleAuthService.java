package services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleAuthService {
    private static final String APPLICATION_NAME = "Orchestra";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Arrays.asList(
            "https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/userinfo.email");
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private final NetHttpTransport httpTransport;
    private final ServiceUtilisateur serviceUtilisateur;

    public GoogleAuthService() throws GeneralSecurityException, IOException {
        this.httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        this.serviceUtilisateur = new ServiceUtilisateur();
    }

    // Méthode pour effacer les jetons stockés et forcer une nouvelle authentification
    public void clearTokens() {
        try {
            File tokensFolder = new File(TOKENS_DIRECTORY_PATH);
            if (tokensFolder.exists() && tokensFolder.isDirectory()) {
                File[] files = tokensFolder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        file.delete();
                    }
                }
                tokensFolder.delete();
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression des jetons: " + e.getMessage());
        }
    }

    /**
     * Récupère les infos utilisateur Google après authentification OAuth2
     */
    public Userinfo getUserInfo() throws IOException {
        // Supprime les jetons précédents pour forcer une nouvelle authentification
        clearTokens();

        // Charge les secrets du client
        InputStream in = GoogleAuthService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Construit le flux d'autorisation
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        // Configuration du serveur local pour la réception du code d'autorisation
        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
                .setPort(8888)
                .build();

        // Autorise l'utilisateur et obtient les credentials
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");

        // Crée le service OAuth2 pour obtenir les informations utilisateur
        Oauth2 oauth2 = new Oauth2.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Exécute la requête pour obtenir les informations de l'utilisateur
        return oauth2.userinfo().get().execute();
    }
}