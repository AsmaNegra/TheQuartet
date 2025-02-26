package tn.esprit.services;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void ajouter_Utili(T t) throws SQLException;
    void modifier_Utili (T t) throws SQLException;
    void supprimer_Utili (int id) throws SQLException;
    List<T> afficher_Utili () throws SQLException;
}
