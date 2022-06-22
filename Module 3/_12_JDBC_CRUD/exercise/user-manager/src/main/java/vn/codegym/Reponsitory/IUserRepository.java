package vn.codegym.Reponsitory;

import vn.codegym.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> findAll() throws SQLException;

    boolean delete(String IDs) throws SQLException;

    void save(User user) throws SQLException;

    List<User> findByName(String name) throws SQLException;
}
