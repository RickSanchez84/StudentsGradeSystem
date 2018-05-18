package ru.innopolis.stc9.GradeSystem.db.dao.speciality;

import ru.innopolis.stc9.GradeSystem.pojo.Speciality;

import java.sql.SQLException;

public interface SpecialityDao {
    Speciality getByID(int id) throws SQLException;
}
