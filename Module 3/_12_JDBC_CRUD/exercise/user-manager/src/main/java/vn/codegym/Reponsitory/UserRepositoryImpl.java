package vn.codegym.Reponsitory;

import vn.codegym.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {


    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email = ?, country = ? where id = ?;";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS);) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
                System.out.println("Load data successfully!");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean delete(String IDs) throws SQLException {
        String[] list = IDs.split(",");
        boolean rowDeleted = false;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {

            for (int i = 0; i < list.length; i++) {
                statement.setString(1, list[i]);
                rowDeleted = statement.executeUpdate() > 0;
            }
        }
        return rowDeleted;
    }

    @Override
    public void save(User user) {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(user.getId() > 0 ? UPDATE_USERS_SQL : INSERT_USERS_SQL);) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            if (user.getId() > 0) {
                preparedStatement.setInt(4, user.getId());
            }

            preparedStatement.executeUpdate();
            System.out.println("Insert successfully!");
        } catch (SQLException e) {
            System.out.println("Insert/update failure!" + e.getMessage());
            printSQLException(e);
        }
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
