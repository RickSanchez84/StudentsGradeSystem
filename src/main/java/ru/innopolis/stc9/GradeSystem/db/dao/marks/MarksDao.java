package ru.innopolis.stc9.GradeSystem.db.dao.marks;

import ru.innopolis.stc9.GradeSystem.pojo.Mark;
import java.sql.SQLException;
import java.util.List;

public interface MarksDao {
    Mark getById(int id) throws SQLException;
    List<Mark> getAllByStudent(int category) throws SQLException;
}
