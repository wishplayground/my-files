package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleConnectionDataSource {
    private static SingleConnectionDataSource singleConnectionDataSource;
    private final Connection connection;
    private SingleConnectionDataSource() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/application.properties"));
        String url = properties.getProperty("app.datasource.url");
        String username = properties.getProperty("app.datasource.username");
        String pw = properties.getProperty("app.datasource.password");
        try {
            connection = DriverManager.getConnection(url, username, pw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingleConnectionDataSource getInstance() throws IOException {
        return (singleConnectionDataSource==null) ? (singleConnectionDataSource =  new SingleConnectionDataSource()) : singleConnectionDataSource;
    }
    public Connection getConnection(){
        return connection;
    }
}
