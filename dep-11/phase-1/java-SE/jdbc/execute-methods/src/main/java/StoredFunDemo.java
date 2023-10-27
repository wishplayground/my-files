import db.SingleConnectionDataSource;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredFunDemo {
    public static void main(String[] args) {
        try(var connection = SingleConnectionDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT addTwoNums(10,20)");
            resultSet.next();
            System.out.println(resultSet.getInt(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
