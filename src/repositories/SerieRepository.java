package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.*;
import services.Database;

public class SerieRepository {
    private Connection connection;
    private static SerieRepository instance;
    
    private SerieRepository() {
        connection = Database.getConnection();
    }

    public static SerieRepository getInstance() {
        if (instance == null) {
            instance = new SerieRepository();
        }
        return instance;
    }

    public void add(Serie serie) {
        String query = "INSERT INTO serie (id_serie, semestru) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, serie.getId_serie());
            statement.setInt(2, serie.getSemestru());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serie serie) {
        String query = "UPDATE serie SET semestru = ? WHERE id_serie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, serie.getSemestru());
            statement.setInt(2, serie.getId_serie());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idSerie) {
        String query = "DELETE FROM serie WHERE id_serie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSerie);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Serie getById(int idSerie) {
        String query = "SELECT * FROM serie WHERE id_serie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSerie);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int semestru = resultSet.getInt("semestru");
                Serie serie = new Serie(idSerie, semestru);
                return serie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Serie> getAll() {
        List<Serie> serieList = new ArrayList<>();
        String query = "SELECT * FROM serie";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idSerie = resultSet.getInt("id_serie");
                int semestru = resultSet.getInt("semestru");
                Serie serie = new Serie(idSerie, semestru);
                serieList.add(serie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return serieList;
    }
}
