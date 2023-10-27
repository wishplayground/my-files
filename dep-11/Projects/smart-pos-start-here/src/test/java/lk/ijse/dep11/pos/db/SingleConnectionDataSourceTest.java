package lk.ijse.dep11.pos.db;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class SingleConnectionDataSourceTest {

    @Test
    void getInstance() {
        assertDoesNotThrow(SingleConnectionDataSource::getInstance);
    }

    @Test
    void getConnection() {
        try(var connection = SingleConnectionDataSource.getInstance().getConnection()){
            Connection connection1 = SingleConnectionDataSource.getInstance().getConnection();
            Connection connection2 = SingleConnectionDataSource.getInstance().getConnection();
            Connection connection3 = SingleConnectionDataSource.getInstance().getConnection();
            Connection connection4 = SingleConnectionDataSource.getInstance().getConnection();
            assertEquals(connection1,connection);
            assertEquals(connection2,connection);
            assertEquals(connection3,connection);
            assertEquals(connection4,connection);
        }catch (Exception e){

        }
    }
}