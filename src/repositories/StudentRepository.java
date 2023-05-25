package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.*;
import services.Database;

public class StudentRepository {
    private static StudentRepository instance;
    private Connection connection;

    private StudentRepository() {
        connection = Database.getConnection();
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void create(Student student) {
        String query = "INSERT INTO studenti (nr_matricol, nume, medie, id_grupa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getNrMatricol());
            statement.setString(2, student.getNume());
            statement.setDouble(3, student.getMedie());
            statement.setInt(4, student.getId_grupa());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getById(int nrMatricol) {
        String query = "SELECT * FROM studenti WHERE nr_matricol = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nrMatricol);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createStudentFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAll() { 
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM studenti";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Student student = createStudentFromResultSet(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void update(Student student) {
        String query = "UPDATE studenti SET nume = ?, medie = ?, id_grupa = ? WHERE nr_matricol = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getNume());
            statement.setDouble(2, student.getMedie());
            statement.setInt(3, student.getId_grupa());
            statement.setInt(4, student.getNrMatricol());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int nrMatricol) {
        String query = "DELETE FROM studenti WHERE nr_matricol = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nrMatricol);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Student createStudentFromResultSet(ResultSet resultSet) throws SQLException {
        String nume = resultSet.getString("nume");
        int idGrupa = resultSet.getInt("id_grupa");
        int nrMatricol = resultSet.getInt("nr_matricol");
        Student student = new Student(nume, idGrupa);
        student.setNrMatricol(nrMatricol);
        return student;
    }
}
