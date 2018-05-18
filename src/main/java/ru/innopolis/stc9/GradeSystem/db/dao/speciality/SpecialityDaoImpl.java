package ru.innopolis.stc9.GradeSystem.db.dao.speciality;

import ru.innopolis.stc9.GradeSystem.db.connection.ConnectionManagerImpl;
import ru.innopolis.stc9.GradeSystem.pojo.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityDaoImpl implements SpecialityDao {

    @Override
    public Speciality getByID(int id) throws SQLException {
        Speciality result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT *" +

                        "FROM Speciality as s" +

                        "WHERE s.id= ?");

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Speciality speciality = new Speciality(
                                                    resultSet.getInt("id")
                                                    ,resultSet.getString("name")
                                                    );

            result=speciality;
        }
        connection.close();
        return result;
    }
}
