package lk.ijse.dep11.pos.db;

import lk.ijse.dep11.pos.tm.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CustomerDataBaseAccess {
    private static final PreparedStatement INSERT_CUSTOMER;
    private static final PreparedStatement UPDATE_CUSTOMER;
    private static final PreparedStatement DELETE_CUSTOMER;
    private static final PreparedStatement LIST_ALL_CUSTOMERS;

    static {
        Connection connection = SingleConnectionDataSource.getInstance().getConnection();
        try {
            INSERT_CUSTOMER = connection.prepareStatement("INSERT INTO customers (id,name,address) VALUES (?,?,?)");
            UPDATE_CUSTOMER = connection.prepareStatement("UPDATE customers SET name=?,address=? WHERE id=?");
            DELETE_CUSTOMER = connection.prepareStatement("DELETE FROM customers WHERE id=?");
            LIST_ALL_CUSTOMERS = connection.prepareStatement("SELECT * FROM customers");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = LIST_ALL_CUSTOMERS.executeQuery();
        List<Customer> customersList = new ArrayList<>();
        while (resultSet.next()){
            customersList.add(new Customer(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("address")));
        }
        return customersList;
    }
    public static void saveCustomer(Customer customer) throws SQLException {
        INSERT_CUSTOMER.setString(1,customer.getId());
        INSERT_CUSTOMER.setString(2,customer.getName());
        INSERT_CUSTOMER.setString(3,customer.getAddress());
        INSERT_CUSTOMER.executeUpdate();
    }

    public static void updateCustomer(Customer customer) throws SQLException {
        UPDATE_CUSTOMER.setString(1,customer.getName());
        UPDATE_CUSTOMER.setString(2, customer.getAddress());
        UPDATE_CUSTOMER.setString(3,customer.getId());
        UPDATE_CUSTOMER.executeUpdate();
    }

    public static void deleteCustomer(String id) throws SQLException {
        DELETE_CUSTOMER.setString(1,id);
    }

    public static int getLastId() throws SQLException {
        if(getAllCustomers().isEmpty()) return 0;
        else {
            return Integer.parseInt(getAllCustomers().get(getAllCustomers().size() - 1).getId().substring(1));
        }
    }
}
