package ru.innopolis.stc9.GradeSystem.db.dao.students;

import ru.innopolis.stc9.GradeSystem.db.connection.ConnectionManagerImpl;
import ru.innopolis.stc9.GradeSystem.db.dao.speciality.SpecialityDaoImpl;
import ru.innopolis.stc9.GradeSystem.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDaoImpl implements StudentsDao {
    @Override
    public Student getById(int id) throws SQLException {

        Student result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT *" +

                        "FROM students" +

                        "WHERE s.id= ?");

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        SpecialityDaoImpl sdi = new SpecialityDaoImpl();

        while (resultSet.next()) {
            Student student = new Student(
                                            resultSet.getInt("id")
                                            ,resultSet.getString("name")
                                            ,resultSet.getInt("age")
                                            ,resultSet.getFloat("progress")
                                            ,sdi.getByID(resultSet.getInt("speciality"))
                                         );
            result= student;
        }
        connection.close();
        return result;
    }

    @Override
    public Student getByName(String name) throws SQLException {
        Student result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT *" +

                        "FROM students" +

                        "WHERE name= ?");

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        SpecialityDaoImpl sdi = new SpecialityDaoImpl();

        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getInt("age")
                    ,resultSet.getFloat("progress")
                    ,sdi.getByID(resultSet.getInt("speciality"))
            );
            result= student;
        }
        connection.close();
        return result;
    }

    @Override
    public List<Student> getAll() throws SQLException {

        ArrayList<Student> result = new ArrayList<>();

        Connection connection = new ConnectionManagerImpl().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM students ");

        ResultSet resultSet = preparedStatement.executeQuery();
        SpecialityDaoImpl sdi = new SpecialityDaoImpl();

        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getInt("age")
                    ,resultSet.getFloat("progress")
                    ,sdi.getByID(resultSet.getInt("speciality"))
            );

            result.add(student);
        }
        connection.close();
        return result;
    }
}
