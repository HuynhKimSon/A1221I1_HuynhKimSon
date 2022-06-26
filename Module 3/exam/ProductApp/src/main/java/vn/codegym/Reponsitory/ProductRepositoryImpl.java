package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {


    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (id_category, name, price, quantity, color, description) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_PRODUCTS = "select * from products;";
    private static final String SELECT_CATEGORY = "select name_category from category where name_category = ?;";

    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set id_category = ?,name = ?, price = ?, quantity = ?,color = ?, description = ? where id = ?;";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

                // get name_category table category
                PreparedStatement preparedStatementCategory = connection.prepareStatement(SELECT_CATEGORY);
                preparedStatementCategory.setInt(1, Integer.parseInt(category));
                ResultSet resultSetCategory = statement.executeQuery();
                String getCategory = resultSet.getString("name_category");

                products.add(new Product(id, name, price, quantity, color, description, getCategory));
                System.out.println("Load data successfully!");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean delete(String IDs) throws SQLException {
        String[] list = IDs.split(",");
        boolean rowDeleted = false;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {

            for (int i = 0; i < list.length; i++) {
                statement.setString(1, list[i]);
                rowDeleted = statement.executeUpdate() > 0;
            }
        }
        return rowDeleted;
    }

    @Override
    public void save(Product product) {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(product.getId() > 0 ? UPDATE_PRODUCTS_SQL : INSERT_PRODUCTS_SQL)) {

            connection.setAutoCommit(false);

            preparedStatement.setInt(1, Integer.parseInt(product.getCategory()));
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());

            if (product.getId() > 0) {
                preparedStatement.setInt(7, product.getId());
            }

            preparedStatement.executeUpdate();
            connection.commit();

            System.out.println("Insert successfully!");
        } catch (SQLException e) {
            System.out.println("Insert/update failure!" + e.getMessage());
            printSQLException(e);
        }
    }

    @Override
    public List<Product> findByName(String name) {
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
