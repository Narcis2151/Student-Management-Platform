package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.*;

public class GrupaRepository {
    private Connection connection;

    private static GrupaRepository instance;

    private GrupaRepository() {
        connection = Database.getConnection();
    }

    public static GrupaRepository getInstance() {
        if (instance == null) {
            instance = new GrupaRepository();
        }
        return instance;
    }

    public void add(Grupa grupa) {
        String query = "INSERT INTO grupa (id_grupa, id_serie) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grupa.getId_grupa());
            statement.setInt(2, grupa.getId_serie());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Grupa grupa) {
        String query = "UPDATE grupa SET id_serie = ? WHERE id_grupa = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grupa.getId_serie());
            statement.setInt(2, grupa.getId_grupa());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idGrupa) {
        String query = "DELETE FROM grupa WHERE id_grupa = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idGrupa);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Grupa getById(int idGrupa) {
        String query = "SELECT * FROM grupa WHERE id_grupa = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idGrupa);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idSerie = resultSet.getInt("id_serie");
                Grupa grupa = new Grupa(idGrupa, idSerie);
                return grupa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Grupa> getAll() {
        List<Grupa> grupaList = new ArrayList<>();
        String query = "SELECT * FROM grupa";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idGrupa = resultSet.getInt("id_grupa");
                int idSerie = resultSet.getInt("id_serie");
                Grupa grupa = new Grupa(idGrupa, idSerie);
                grupaList.add(grupa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupaList;
    }
}
