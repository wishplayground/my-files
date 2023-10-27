import db.SingleConnectionDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {
    public static void main(String[] args) {
        try(var connection =  SingleConnectionDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('Kasun','sandalnkawa')");
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('amal','kandy')");
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('tharun','wewagama')");
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('Tharuki','Deegalle')");
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('Muditha','walipillawa')");
            statement.addBatch("INSERT INTO Customer (name,address) VALUES ('ishani','karagahagedara')");
            statement.addBatch("DELETE FROM Customer WHERE address='Deegalle'");
            int[] affectedRows = statement.executeBatch();
            for (int affectedRow : affectedRows) {
                System.out.println(affectedRow);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
