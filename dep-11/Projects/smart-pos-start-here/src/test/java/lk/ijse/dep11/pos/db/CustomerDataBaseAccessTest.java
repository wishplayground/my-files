package lk.ijse.dep11.pos.db;

import lk.ijse.dep11.pos.tm.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.SQLInput;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDataBaseAccessTest {
    @BeforeEach
    void setUp() throws SQLException {
        SingleConnectionDataSource.getInstance().getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        SingleConnectionDataSource.getInstance().getConnection().rollback();
        SingleConnectionDataSource.getInstance().getConnection().setAutoCommit(true);
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void saveCustomer() {
        assertDoesNotThrow(()->{
            CustomerDataBaseAccess.saveCustomer(new Customer("C001","Aravinda","Galle"));
        });
    }

    @Test
    void updateCustomer() throws SQLException {
        CustomerDataBaseAccess.saveCustomer(new Customer("C001","Aravinda","Galle"));
        assertDoesNotThrow(()->{
            CustomerDataBaseAccess.updateCustomer(new Customer("C001","Aravinda","Matara"));
        });
    }

    @Test
    void deleteCustomer() throws SQLException {
        CustomerDataBaseAccess.saveCustomer(new Customer("C001","Aravinda","Galle"));
        assertDoesNotThrow(()->{
            CustomerDataBaseAccess.deleteCustomer("C001");
        });
    }

    @Test
    void getLastId() throws SQLException {
        assertTrue(CustomerDataBaseAccess.getLastId()==0);
        CustomerDataBaseAccess.saveCustomer(new Customer("C001","Aravinda","Galle"));
        assertTrue(CustomerDataBaseAccess.getLastId()==1);
    }
}