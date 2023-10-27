package lk.ijse.dep11.pos.db;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class SingleConnectionDataSource {
    private static SingleConnectionDataSource instance;
    private final Connection connection;

    private SingleConnectionDataSource(){
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("app.db.url"),properties.getProperty("app.db.username"),properties.getProperty("app.db.passwd"));
            generateSchema();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SingleConnectionDataSource getInstance(){
        return (Objects.equals(instance,null))? instance = new SingleConnectionDataSource() : instance;
    }
    public Connection getConnection(){
        return connection;
    }

    private void generateSchema(){
        try {
            Path pathRef = Paths.get(Objects.requireNonNull(getClass().getResource("/schema.sql")).toURI());
            Optional<String> reduce = Files.readAllLines(pathRef).stream().reduce((prev, cur) -> prev + cur);
            if(reduce.isPresent()){
                connection.createStatement().execute(reduce.get());
            }
        } catch (URISyntaxException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
