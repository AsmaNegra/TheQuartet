package utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import entities.Evenement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GoogleCalendarService {
    private static final String APPLICATION_NAME = "Votre Application";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static Calendar service;

    /**
     * Crée un objet Credential autorisé.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Charger les secrets clients
        InputStream in = GoogleCalendarService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Construire le flow pour l'autorisation
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
            .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
            .setAccessType("offline")
            .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();

        // Autoriser et retourner le Credential
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Initialiser le service Google Calendar.
     */
    private static void initService() throws IOException, GeneralSecurityException {
        if (service == null) {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        }
    }

    /**
     * Retourne les événements Google Calendar pour une période donnée.
     */
    public static List<Event> getEvents(Date startDate, Date endDate) throws IOException, GeneralSecurityException {
        initService();

        DateTime start = new DateTime(startDate);
        DateTime end = new DateTime(endDate);

        Events events = service.events().list("primary")
            .setTimeMin(start)
            .setTimeMax(end)
            .setOrderBy("startTime")
            .setSingleEvents(true)
            .execute();

        return events.getItems();
    }

    /**
     * Ajoute un événement à Google Calendar.
     */
    public static Event addEvent(Evenement evenement) throws IOException, GeneralSecurityException {
        initService();

        Event event = new Event()
            .setSummary(evenement.getNom())
            .setDescription(evenement.getDescription())
            .setLocation(evenement.getLieu());

        DateTime startDateTime = new DateTime(evenement.getDate_debut());
        EventDateTime start = new EventDateTime()
            .setDateTime(startDateTime);
        event.setStart(start);

        DateTime endDateTime = new DateTime(evenement.getDate_fin());
        EventDateTime end = new EventDateTime()
            .setDateTime(endDateTime);
        event.setEnd(end);

        // Ajouter l'événement au calendrier principal
        event = service.events().insert("primary", event).execute();

        return event;
    }

    /**
     * Synchronise tous les événements de l'application avec Google Calendar.
     */
    public static void syncEvents(List<Evenement> appEvents) throws IOException, GeneralSecurityException {
        initService();

        // Convertir les dates pour une période d'un an
        Date now = new Date();
        Date oneYearLater = new Date(now.getTime() + 365L * 24 * 60 * 60 * 1000);

        // Récupérer les événements existants dans Google Calendar
        List<Event> googleEvents = getEvents(now, oneYearLater);

        // Ajouter chaque événement de l'application qui n'existe pas déjà dans Google Calendar
        for (Evenement appEvent : appEvents) {
            boolean exists = false;

            // Vérifier si l'événement existe déjà (par nom et date)
            for (Event googleEvent : googleEvents) {
                if (googleEvent.getSummary().equals(appEvent.getNom()) &&
                    new DateTime(appEvent.getDate_debut()).equals(googleEvent.getStart().getDateTime())) {
                    exists = true;
                    break;
                }
            }

            // Si l'événement n'existe pas, l'ajouter
            if (!exists) {
                addEvent(appEvent);
            }
        }
    }
}
