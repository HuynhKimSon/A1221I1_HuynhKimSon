package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {


    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (id_category, name, price, quantity, color, description) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_PRODUCTS = "select * from products p inner join category c on p.id_category = c.id_category;";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set id_category = ?,name = ?, price = ?, quantity = ?,color = ?, description = ? where id = ?;";
    private static final String SEARCH_BY_NAME = "select * from products p inner join category c on p.id_category = c.id_category where p.name LIKE concat('%',?,'%');";
    private static final String SEARCH_BY_PRICE = "select * from products p inner join category c on p.id_category = c.id_category  where p.price LIKE concat(?,'%');";
    private static final String SEARCH_BY_QUANTITY = "select * from products p inner join category c on p.id_category = c.id_category  where p.quantity LIKE concat(?,'%');";
    private static final String SEARCH_BY_CATEGORY = "select * from products p inner join category c on p.id_category = c.id_category where c.name_category LIKE concat('%',?,'%');";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // get info table product
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = Double.parseDouble(rs.getString("price"));
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("name_category");

                products.add(new Product(id, name, price, quantity, color, description, category));
            }
            System.out.println("Load data successfully!");
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
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL)) {

            for (int i = 0; i < list.length; i++) {
                statement.setString(1, list[i]);
                rowDeleted = statement.executeUpdate() > 0;
            }
        }
        return rowDeleted;
    }

    @Override
    public void save(Product product) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement st = connection.prepareStatement(product.getId() > 0 ? UPDATE_PRODUCTS_SQL : INSERT_PRODUCTS_SQL);
        if (connection != null) {
            try {
                connection.setAutoCommit(false);

                st.setInt(1, Integer.parseInt(product.getCategory()));
                st.setString(2, product.getName());
                st.setDouble(3, product.getPrice());
                st.setInt(4, product.getQuantity());
                st.setString(5, product.getColor());
                st.setString(6, product.getDescription());

                if (product.getId() > 0) {
                    st.setInt(7, product.getId());
                }

                st.executeUpdate();
                connection.commit();
                System.out.println("Insert successfully!");
            } catch (SQLException e) {
                System.out.println("Insert/update failure!" + e.getMessage());
                printSQLException(e);

            } finally {
                st.close();
                connection.setAutoCommit(true);
                DbConnection.close();
            }
        }
    }

    @Override
    public List<Product> findBy(String key, String value) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                switch (key) {
                    case "name":
                        st = connection.prepareStatement(SEARCH_BY_NAME);
                        break;
                    case "price":
                        st = connection.prepareStatement(SEARCH_BY_PRICE);
                    case "quantity":
                        st = connection.prepareStatement(SEARCH_BY_QUANTITY);
                        break;
                    default:
                        st = connection.prepareStatement(SEARCH_BY_CATEGORY);

                }
                st.setString(1, value);
                rs = st.executeQuery();
                while (rs.next()) {
                    // get info table product
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = Double.parseDouble(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String color = rs.getString("color");
                    String description = rs.getString("description");
                    String category = rs.getString("name_category");

                    products.add(new Product(id, name, price, quantity, color, description, category));
                }
            } finally {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DbConnection.close();
            }
        }
        return products;
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
