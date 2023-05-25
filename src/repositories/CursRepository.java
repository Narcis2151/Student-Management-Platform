package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.Database;

public class CursRepository {
    private Connection connection;
    private MaterieRepository materieRepository = MaterieRepository.getInstance();
    
    private static CursRepository instance;

    private CursRepository() {
        connection = Database.getConnection();
    }

    public static CursRepository getInstance() {
        if (instance == null) {
            instance = new CursRepository();
        }
        return instance;
    }

    public void add(Curs curs) {
        String query = "INSERT INTO curs (id_serie, id_profesor, mod_evaluare, sala, nume_materie) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, curs.getId_serie());
            statement.setInt(2, curs.getId_profesor());
            statement.setString(3, curs.getModEvaluare());
            statement.setString(4, curs.getSala());
            statement.setString(5, curs.getNume());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Curs curs) {
        String query = "UPDATE curs SET id_serie = ?, id_profesor = ?, mod_evaluare = ?, sala = ? WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, curs.getId_serie());
            statement.setInt(2, curs.getId_profesor());
            statement.setString(3, curs.getModEvaluare());
            statement.setString(4, curs.getSala());
            statement.setString(5, curs.getNume());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String nume_materie) {
        String query = "DELETE FROM curs WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nume_materie);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Curs getById(String nume_materie) {
        String query = "SELECT * FROM curs WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nume_materie);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idSerie = resultSet.getInt("id_serie");
                int idProfesor = resultSet.getInt("id_profesor");
                String modEvaluare = resultSet.getString("mod_evaluare");
                String sala = resultSet.getString("sala");
                Materie materie = materieRepository.getByNume(nume_materie);
                Curs curs = new Curs(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idSerie, idProfesor, modEvaluare, sala);
                return curs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Curs> getAll() {
        List<Curs> cursList = new ArrayList<>();
        String query = "SELECT * FROM curs";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idSerie = resultSet.getInt("id_serie");
                int idProfesor = resultSet.getInt("id_profesor");
                String modEvaluare = resultSet.getString("mod_evaluare");
                String sala = resultSet.getString("sala");
                String numeMaterie = resultSet.getString("nume_materie");
                Materie materie = materieRepository.getByNume(numeMaterie);
                Curs curs = new Curs(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idSerie, idProfesor, modEvaluare, sala);
                cursList.add(curs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursList;
    }

}
