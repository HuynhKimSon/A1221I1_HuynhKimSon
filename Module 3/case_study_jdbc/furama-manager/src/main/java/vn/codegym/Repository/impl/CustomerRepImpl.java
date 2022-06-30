package vn.codegym.Repository.impl;

import vn.codegym.Model.Customer;
import vn.codegym.Repository.DbConnection;
import vn.codegym.Repository.ICustomerRep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepImpl implements ICustomerRep {

    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?);";
    private static final String UPDATE_PRODUCTS_SQL = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?,customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?;";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer c inner join customer_type ct on c.customer_type_id = ct.customer_type_id;";
    private static final String DELETE_PRODUCTS_SQL = "delete from customer where customer_id = ?;";


    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // get info table product
                int customerId = rs.getInt("customer_id");
                String customerType = rs.getString("customer_type_name");
                String customerName = rs.getString("customer_name");
                String customerBirthday = rs.getString("customer_birthday");
                int customerGender = rs.getInt("customer_gender");
                int customerIdCard = rs.getInt("customer_id_card");
                int customerPhone = rs.getInt("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");

                customers.add(new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
            }
            System.out.println("Load data successfully!");
            System.out.println("-----------------------------------------------!");
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
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
        System.out.println("Delete successfully!");
        System.out.println("-----------------------------------------------!");
        return rowDeleted;
    }

    @Override
    public void save(Customer customer) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement st = connection.prepareStatement(customer.getCustomerId() > 0 ? UPDATE_PRODUCTS_SQL : INSERT_PRODUCTS_SQL);
        if (connection != null) {
            try {
                connection.setAutoCommit(false);

                st.setInt(1, Integer.parseInt(customer.getCustomerType()));
                st.setString(2, customer.getCustomerName());
                st.setString(3, customer.getCustomerBirthday());
                st.setInt(4, customer.getCustomerGender());
                st.setInt(5, customer.getCustomerIdCard());
                st.setInt(6, customer.getCustomerPhone());
                st.setString(7, customer.getCustomerEmail());
                st.setString(8, customer.getCustomerAddress());

                if (customer.getCustomerId() > 0) {
                    st.setInt(9, customer.getCustomerId());
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
        System.out.println("-----------------------------------------------!");
    }

    @Override
    public List<Customer> findBy(String key, String value) throws SQLException {
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
