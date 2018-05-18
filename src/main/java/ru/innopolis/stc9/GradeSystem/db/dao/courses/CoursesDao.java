package ru.innopolis.stc9.GradeSystem.db.dao.courses;

import ru.innopolis.stc9.GradeSystem.pojo.Course;

import java.sql.SQLException;

public interface CoursesDao {
    Course getById(int id) throws SQLException;
}
