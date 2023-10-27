package lk.ijse.dep11.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;

public class DbConnection {
    private static DbConnection dbConnection;
    private final Connection connection;
    private DbConnection(){
        try{
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/application.properties"));
            String url=properties.getProperty("app.db.url");
            String username = properties.getProperty("app.db.username");
            String password = properties.getProperty("app.db.password");
            connection =  DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DbConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
    public Connection getConnection() {
        return connection;
    }
}
