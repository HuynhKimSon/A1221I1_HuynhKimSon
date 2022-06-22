package vn.codegym.Reponsitory;

import vn.codegym.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country, cmnd) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select from users where cmnd =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where cmnd = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where cmnd = ?;";

    public UserRepositoryImpl() {
    }

    private Connection getConnection() {
        System.out.println("Connecting database...");
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (SQLException e) {
            System.out.println("Connect failure SQLException!" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Connect failure ClassNotFoundException!" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (
                Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("cmnd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
                System.out.println("Insert successfully!");
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {

            for (int i = 0; i < list.length; i++) {
                statement.setString(1, list[i]);
                rowDeleted = statement.executeUpdate() > 0;
            }

        }
        return rowDeleted;
    }

    @Override
    public void save(User user) {
        Boolean isAction = findByCMND(user.getId());
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(isAction ? UPDATE_USERS_SQL : INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            if (isAction) {
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

    public boolean findByCMND(int cmnd) {
        boolean isFindByCMND = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            ResultSet rs = null;
            preparedStatement.setInt(1, cmnd);
            rs = preparedStatement.executeQuery();
            isFindByCMND = true;
            System.out.println("findByCMND successfully!");
        } catch (SQLException e) {
            System.out.println("findByCMND failure!" + e.getMessage());
            printSQLException(e);
        }
        return isFindByCMND;
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
