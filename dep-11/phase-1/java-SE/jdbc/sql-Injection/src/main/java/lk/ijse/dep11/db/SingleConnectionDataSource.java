package lk.ijse.dep11.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SingleConnectionDataSource {
    private static SingleConnectionDataSource singleConnectionSource;
    private final Connection connection;
    private SingleConnectionDataSource(){

        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream ("/application.properties"));
            String id = properties.getProperty("app.datasource.url");
            String username = properties.getProperty("app.datasource.user");
            String passwd =   properties.getProperty("app.datasource.password");
            connection = DriverManager.getConnection(id, username, passwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public static SingleConnectionDataSource getInstance(){
        if(singleConnectionSource == null) singleConnectionSource = new SingleConnectionDataSource();
        return singleConnectionSource;
    }
    public Connection getConnection(){
        return connection;
    }
}
