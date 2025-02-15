package services;

import utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceCategorie {
    private Connection connection;

    public ServiceCategorie() {
        connection = MyDataBase.getInstance().getConnection();
    }

    public List<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT categorie FROM listecategorieevent";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("categorie"));
            }
        }
        return categories;
    }
}
