package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.Database;

public class ProfesorRepository {
    private Connection connection;

    private static ProfesorRepository instance;

    private ProfesorRepository() {
        connection = Database.getConnection();
    }

    public static ProfesorRepository getInstance() {
        if (instance == null) {
            instance = new ProfesorRepository();
        }
        return instance;
    }

    public void add(Profesor profesor) {
        String query = "INSERT INTO profesor (id_profesor, nume, titlu, salariu) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, profesor.getId_profesor());
            statement.setString(2, profesor.getNume());
            statement.setString(3, profesor.getTitlu());
            statement.setDouble(4, profesor.getSalariu());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Profesor profesor) {
        String query = "UPDATE profesor SET nume = ?, titlu = ?, salariu = ? WHERE id_profesor = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, profesor.getNume());
            statement.setString(2, profesor.getTitlu());
            statement.setDouble(3, profesor.getSalariu());
            statement.setInt(4, profesor.getId_profesor());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idProfesor) {
        String query = "DELETE FROM profesor WHERE id_profesor = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idProfesor);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profesor getById(int idProfesor) {
        String query = "SELECT * FROM profesor WHERE id_profesor = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idProfesor);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String titlu = resultSet.getString("titlu");
                double salariu = resultSet.getDouble("salariu");
                Profesor profesor = new Profesor(nume, titlu, salariu);
                profesor.setId_profesor(idProfesor);
                return profesor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Profesor> getAll() {
        List<Profesor> profesorList = new ArrayList<>();
        String query = "SELECT * FROM profesor";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String titlu = resultSet.getString("titlu");
                double salariu = resultSet.getDouble("salariu");
                Profesor profesor = new Profesor(nume, titlu, salariu);
                profesor.setId_profesor(resultSet.getInt("id_profesor"));
                profesorList.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profesorList;
    }
}

