package vn.codegym.Service;

import vn.codegym.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> findAll() throws SQLException;

    void delete(String IDs) throws SQLException;

    void save(User user) throws SQLException;

    List<User> findByName(String name);
}
