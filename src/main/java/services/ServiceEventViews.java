package services;

import utils.MyDataBase;
import java.sql.*;

public class ServiceEventViews {
    private Connection connection;

    public ServiceEventViews() {
        connection = MyDataBase.getInstance().getConnection();
    }

    // Incrémente le compteur de vues pour un événement
    public void incrementViewCount(int eventId) {
        String sql = "INSERT INTO event_views (event_id, view_count) VALUES (?, 1) " +
            "ON DUPLICATE KEY UPDATE view_count = view_count + 1";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'incrémentation du compteur de vues: " + e.getMessage());
        }
    }
}
