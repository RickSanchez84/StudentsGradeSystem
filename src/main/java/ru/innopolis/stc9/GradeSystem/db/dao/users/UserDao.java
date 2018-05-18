package ru.innopolis.stc9.GradeSystem.db.dao.users;

import ru.innopolis.stc9.GradeSystem.pojo.User;

import java.sql.SQLException;

public interface UserDao {
    public User getUserByLogin(String login) throws SQLException;
    public User getUserById(int id) throws SQLException;
}
