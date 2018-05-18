package ru.innopolis.stc9.GradeSystem.db.dao.students;

import ru.innopolis.stc9.GradeSystem.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentsDao {
    Student getById(int id) throws SQLException;
    Student getByName(String name) throws SQLException;
    List<Student> getAll() throws SQLException;

}
