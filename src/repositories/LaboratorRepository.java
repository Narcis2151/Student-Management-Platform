package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.*;

public class LaboratorRepository {
    private Connection connection;

    private static LaboratorRepository instance;

    private LaboratorRepository() {
        connection = Database.getConnection();
    }

    public static LaboratorRepository getInstance() {
        if (instance == null) {
            instance = new LaboratorRepository();
        }
        return instance;
    }

    public void add(Laborator laborator) {
        String query = "INSERT INTO laborator (id_grupa, id_profesor, limbajProgramare, laborator, nume_materie) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, laborator.getId_grupa());
            statement.setInt(2, laborator.getId_profesor());
            statement.setString(3, laborator.getLimbajProgramare());
            statement.setString(4, laborator.getLab());
            statement.setString(5, laborator.getNume());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Laborator laborator) {
        String query = "UPDATE laborator SET id_grupa = ?, id_profesor = ?, limbaj_programare = ?, laborator = ? WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, laborator.getId_grupa());
            statement.setInt(2, laborator.getId_profesor());
            statement.setString(3, laborator.getLimbajProgramare());
            statement.setString(4, laborator.getLab());
            statement.setString(5, laborator.getNume());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String numeMaterie) {
        String query = "DELETE FROM laborator WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, numeMaterie);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Laborator getById(String numeMaterie) {
        String query = "SELECT * FROM laborator WHERE nume_materie = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, numeMaterie);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idGrupa = resultSet.getInt("id_grupa");
                int idProfesor = resultSet.getInt("id_profesor");
                String limbajProgramare = resultSet.getString("limbaj_programare");
                String lab = resultSet.getString("laborator");
                String nume = resultSet.getString("nume_materie");
                Materie materie = MaterieRepository.getInstance().getByNume(nume);
                Profesor profesor = ProfesorRepository.getInstance().getById(idProfesor);
                Grupa grupa = GrupaRepository.getInstance().getById(idGrupa);
                Laborator laborator = new Laborator(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idGrupa, idProfesor, limbajProgramare, lab);
                laborator.setGrupa(grupa);
                laborator.setProfesor(profesor);
                return laborator;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Laborator> getAll() {
        List<Laborator> laboratorList = new ArrayList<>();
        String query = "SELECT * FROM laborator";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idGrupa = resultSet.getInt("id_grupa");
                int idProfesor = resultSet.getInt("id_profesor");
                String limbajProgramare = resultSet.getString("limbaj_programare");
                String lab = resultSet.getString("laborator");
                String nume = resultSet.getString("nume_materie");
                Materie materie = MaterieRepository.getInstance().getByNume(nume);
                Profesor profesor = ProfesorRepository.getInstance().getById(idProfesor);
                Grupa grupa = GrupaRepository.getInstance().getById(idGrupa);
                Laborator laborator = new Laborator(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idGrupa, idProfesor, limbajProgramare, lab);
                laborator.setGrupa(grupa);
                laborator.setProfesor(profesor);
                laboratorList.add(laborator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laboratorList;
    }

    public List<Laborator> getAllByGrupa(int id_grupa){
        List<Laborator> laboratoare = new ArrayList<>();
        String query = "SELECT * FROM laborator WHERE id_grupa = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id_grupa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idGrupa = resultSet.getInt("id_grupa");
                int idProfesor = resultSet.getInt("id_profesor");
                String limbajProgramare = resultSet.getString("limbaj_programare");
                String lab = resultSet.getString("laborator");
                String nume = resultSet.getString("nume_materie");
                Materie materie = MaterieRepository.getInstance().getByNume(nume);
                Profesor profesor = ProfesorRepository.getInstance().getById(idProfesor);
                Grupa grupa = GrupaRepository.getInstance().getById(idGrupa);
                Laborator laborator = new Laborator(materie.getNume(), materie.getNumar_credite(), materie.getNumar_ore(), idGrupa, idProfesor, limbajProgramare, lab);
                laborator.setGrupa(grupa);
                laborator.setProfesor(profesor);
                laboratoare.add(laborator);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laboratoare;
    }
}

