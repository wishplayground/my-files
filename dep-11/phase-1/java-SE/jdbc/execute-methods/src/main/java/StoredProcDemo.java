import db.SingleConnectionDataSource;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcDemo {
    public static void main(String[] args) {

        try(var connection = SingleConnectionDataSource.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("{CALL showCustomer('kan')}");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.printf("id = %s  name = %s    address = %s",resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
