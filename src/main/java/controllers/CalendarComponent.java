
package controllers;

import entities.Evenement;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import services.ServiceEvenement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarComponent {

    @FXML
    private VBox calendarContainer;

    private YearMonth currentYearMonth;
    private Label monthYearLabel;
    private GridPane calendarGrid;
    private ServiceEvenement serviceEvenement;

    private Map<LocalDate, List<Evenement>> eventsByDate = new HashMap<>();

    public CalendarComponent(VBox container, ServiceEvenement service) {
        this.calendarContainer = container;
        this.serviceEvenement = service;
        this.currentYearMonth = YearMonth.now();
        initialize();
    }

    private void initialize() {
        // Créer le titre du mois/année et les boutons de navigation
        HBox header = createCalendarHeader();

        // Créer la grille des jours de la semaine
        HBox weekdaysHeader = createWeekdaysHeader();

        // Créer la grille du calendrier
        calendarGrid = new GridPane();
        calendarGrid.setHgap(5);
        calendarGrid.setVgap(5);
        calendarGrid.setAlignment(Pos.CENTER);

        // Ajouter les composants au conteneur
        calendarContainer.getChildren().clear();
        calendarContainer.getChildren().addAll(header, weekdaysHeader, calendarGrid);
        calendarContainer.setSpacing(10);
        calendarContainer.setPadding(new Insets(10));
        calendarContainer.setStyle("-fx-background-color: white; -fx-background-radius: 10px; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        // Charger les événements et remplir le calendrier
        loadEventsForMonth();
        populateCalendar();
    }

    private HBox createCalendarHeader() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setSpacing(20);

        Button prevButton = new Button("<");
        prevButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            updateCalendar();
        });

        Button nextButton = new Button(">");
        nextButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            updateCalendar();
        });

        monthYearLabel = new Label();
        monthYearLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        updateMonthYearLabel();

        header.getChildren().addAll(prevButton, monthYearLabel, nextButton);
        return header;
    }

    private HBox createWeekdaysHeader() {
        HBox weekdays = new HBox();
        weekdays.setAlignment(Pos.CENTER);
        weekdays.setSpacing(20);

        // Ajouter les labels des jours de la semaine (S, M, T, W, T, F, S)
        String[] days = {"D", "L", "M", "M", "J", "V", "S"};
        for (String day : days) {
            Label dayLabel = new Label(day);
            dayLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #777777;");
            dayLabel.setPrefWidth(30);
            dayLabel.setAlignment(Pos.CENTER);
            weekdays.getChildren().add(dayLabel);
        }

        return weekdays;
    }

    private void updateMonthYearLabel() {
        String monthName = currentYearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        monthYearLabel.setText(monthName + " " + currentYearMonth.getYear());
    }

    private void updateCalendar() {
        updateMonthYearLabel();
        loadEventsForMonth();
        populateCalendar();
    }

    private void loadEventsForMonth() {
        eventsByDate.clear();

        try {
            List<Evenement> allEvents = serviceEvenement.afficher();

            // Format pour extraire la date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (Evenement event : allEvents) {
                // Pour la date de début
                Date startDate = event.getDate_debut();
                if (startDate != null) {
                    LocalDate localStartDate = startDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                    // Si l'événement commence dans le mois courant
                    if (localStartDate.getYear() == currentYearMonth.getYear() &&
                        localStartDate.getMonthValue() == currentYearMonth.getMonthValue()) {

                        eventsByDate.computeIfAbsent(localStartDate, k -> new ArrayList<>()).add(event);
                    }
                }

                // On pourrait aussi gérer les événements qui s'étendent sur plusieurs jours
                // en ajoutant des entrées pour chaque jour de l'événement
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des événements : " + e.getMessage());
        }
    }

    private void populateCalendar() {
        calendarGrid.getChildren().clear();

        LocalDate firstOfMonth = currentYearMonth.atDay(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue() % 7; // 0 = Dimanche, 6 = Samedi

        // Jours du mois précédent
        YearMonth prevMonth = currentYearMonth.minusMonths(1);
        int prevMonthDays = prevMonth.lengthOfMonth();

        // Ajouter les jours du mois précédent
        for (int i = 0; i < dayOfWeek; i++) {
            int day = prevMonthDays - dayOfWeek + i + 1;
            addDayCell(day, 0, i, true, LocalDate.of(prevMonth.getYear(), prevMonth.getMonthValue(), day));
        }

        // Ajouter les jours du mois courant
        int daysInMonth = currentYearMonth.lengthOfMonth();
        int row = 0;
        int col = dayOfWeek;

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = LocalDate.of(currentYearMonth.getYear(), currentYearMonth.getMonthValue(), day);
            addDayCell(day, row, col, false, date);

            col++;
            if (col > 6) {
                col = 0;
                row++;
            }
        }

        // Ajouter les jours du mois suivant
        YearMonth nextMonth = currentYearMonth.plusMonths(1);
        int nextDay = 1;

        while (row < 6) {
            if (col > 6) {
                col = 0;
                row++;
                continue;
            }

            LocalDate date = LocalDate.of(nextMonth.getYear(), nextMonth.getMonthValue(), nextDay);
            addDayCell(nextDay, row, col, true, date);
            nextDay++;
            col++;
        }
    }

    private void addDayCell(int day, int row, int col, boolean isOtherMonth, LocalDate date) {
        VBox cell = new VBox(5);
        cell.setAlignment(Pos.CENTER);
        cell.setPadding(new Insets(5));
        cell.setPrefSize(40, 40);

        // Label pour le jour
        Label dayLabel = new Label(String.valueOf(day));

        // Vérifier si c'est aujourd'hui
        boolean isToday = date.equals(LocalDate.now());

        // Style de base
        String baseStyle = "-fx-background-radius: 20px;";

        if (isOtherMonth) {
            // Jour d'un autre mois
            dayLabel.setStyle("-fx-text-fill: #AAAAAA;");
            cell.setStyle(baseStyle + "-fx-background-color: #FFFFFF;");
        } else if (isToday) {
            // Aujourd'hui
            dayLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
            cell.setStyle(baseStyle + "-fx-background-color: #007BFF;");
        } else {
            // Jour normal du mois courant
            dayLabel.setStyle("-fx-text-fill: #000000;");
            cell.setStyle(baseStyle + "-fx-background-color: #FFFFFF;");

            // Vérifier si ce jour a des événements
            if (eventsByDate.containsKey(date)) {
                // Marqueur d'événement
                Circle eventMarker = new Circle(3, Color.ORANGE);
                cell.getChildren().add(eventMarker);

                // Ajouter l'info-bulle avec les noms des événements
                StringBuilder tooltip = new StringBuilder();
                for (Evenement event : eventsByDate.get(date)) {
                    if (tooltip.length() > 0) tooltip.append("\n");
                    tooltip.append(event.getNom());
                }

                javafx.scene.control.Tooltip eventTooltip = new javafx.scene.control.Tooltip(tooltip.toString());
                javafx.scene.control.Tooltip.install(cell, eventTooltip);

                // Ajouter l'action de clic pour afficher les détails
                cell.setOnMouseClicked(e -> showEventsForDate(date));
                cell.setStyle(baseStyle + "-fx-background-color: #F0F8FF; -fx-cursor: hand;");
            }
        }

        cell.getChildren().add(0, dayLabel);

        // Permettre à l'utilisateur de cliquer sur une date pour voir ou ajouter des événements
        cell.setOnMouseClicked(e -> dateClicked(date));

        calendarGrid.add(cell, col, row);
    }

    private void dateClicked(LocalDate date) {
        // Ici vous pouvez implémenter l'action lors du clic sur une date
        System.out.println("Date cliquée: " + date);
    }

    private void showEventsForDate(LocalDate date) {
        List<Evenement> events = eventsByDate.get(date);
        if (events != null && !events.isEmpty()) {
            // Ici vous pouvez ouvrir une fenêtre ou afficher les événements
            // dans une autre partie de votre application
            System.out.println("Événements pour " + date + ":");
            for (Evenement event : events) {
                System.out.println("  - " + event.getNom());
            }
        }
    }

    // Méthode publique pour rafraîchir le calendrier
    public void refreshCalendar() {
        loadEventsForMonth();
        populateCalendar();
    }
}
