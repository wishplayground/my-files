package lk.ijse.dep11.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {


    @Test
    void getDbConnection() {
    }

    @Test
    void getConnection() {
        assertDoesNotThrow(()->{
            Connection connection1 = DBConnection.getDbConnection().getConnection();
            Connection connection2 = DBConnection.getDbConnection().getConnection();
            assertEquals(connection1,connection2);
        });
    }
}