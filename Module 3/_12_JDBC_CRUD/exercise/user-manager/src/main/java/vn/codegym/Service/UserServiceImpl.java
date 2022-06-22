package vn.codegym.Service;

import vn.codegym.Model.User;
import vn.codegym.Reponsitory.IUserRepository;
import vn.codegym.Reponsitory.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public void delete(String IDs) throws SQLException {
        userRepository.delete(IDs);
    }

    @Override
    public void save(User user) throws SQLException {
        userRepository.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }
}
