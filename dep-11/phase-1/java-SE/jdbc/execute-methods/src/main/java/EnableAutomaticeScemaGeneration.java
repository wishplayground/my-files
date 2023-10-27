import db.SingleConnectionDataSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EnableAutomaticeScemaGeneration {
    public static void main(String[] args) throws URISyntaxException {
        try( var connection = SingleConnectionDataSource.getInstance().getConnection()) {
            Path pathRef = Paths.get(EnableAutomaticeScemaGeneration.class.getResource("/schema.sql").toURI());
            List<String> lines = Files.readAllLines(pathRef);
            //lines.forEach(System.out::println);
            String s = lines.stream().reduce((prev, cur) ->
                    prev + cur + "\n"
            ).get();
            //System.out.println(s);
            Statement statement = connection.createStatement();
            System.out.println(statement.execute(s));//true
            System.out.println(statement.getUpdateCount());;
            System.out.println(statement.getMoreResults());
            ResultSet resultSet = statement.getResultSet();
            while ( resultSet.next()){
                System.out.printf("id = %s   name = %s   address = %s\n",resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("address"));
            }
            System.out.println(statement.getMoreResults());
            System.out.println(statement.getUpdateCount());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //new EnableAutomaticeScemaGeneration().myMethod();
    }
    public void myMethod() throws URISyntaxException {
        URL resource = this.getClass().getResource("");
        System.out.println(getClass().toString());
    }
}
