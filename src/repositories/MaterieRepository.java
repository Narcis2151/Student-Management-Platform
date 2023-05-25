package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.Database;

public class MaterieRepository {
    private Connection connection;

    private static MaterieRepository instance;

    private MaterieRepository() {
        connection = Database.getConnection();
    }

    public static MaterieRepository getInstance() {
        if (instance == null) {
            instance = new MaterieRepository();
        }
        return instance;
    }

    public void add(Materie materie) {
        String query = "INSERT INTO materie (nume, numar_credite, numar_ore) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, materie.getNume());
            statement.setInt(2, materie.getNumar_credite());
            statement.setInt(3, materie.getNumar_ore());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Materie materie) {
        String query = "UPDATE materie SET numar_credite = ?, numar_ore = ? WHERE nume = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, materie.getNumar_credite());
            statement.setInt(2, materie.getNumar_ore());
            statement.setString(3, materie.getNume());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String nume) {
        String query = "DELETE FROM materie WHERE nume = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nume);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Materie getByNume(String nume) {
        String query = "SELECT * FROM materie WHERE nume = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nume);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int numarCredite = resultSet.getInt("numar_credite");
                int numarOre = resultSet.getInt("numar_ore");
                return new Materie(nume, numarCredite, numarOre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Materie> getAll() {
        List<Materie> materieList = new ArrayList<>();
        String query = "SELECT * FROM materie";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                int numarCredite = resultSet.getInt("numar_credite");
                int numarOre = resultSet.getInt("numar_ore");

                Materie materie = new Materie(nume, numarCredite, numarOre);
                materieList.add(materie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materieList;
    }
}

