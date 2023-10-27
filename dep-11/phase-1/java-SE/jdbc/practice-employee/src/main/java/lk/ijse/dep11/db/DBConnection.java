package lk.ijse.dep11.db;

import lombok.Data;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Data
public class DBConnection {
    //use singleton design pattern
    private static DBConnection dbConnection;
    private final Connection connection;
    private DBConnection(){
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/application.properties"));
            String url = properties.getProperty("app.db.url");
            String username = properties.getProperty("app.db.username");
            String password = properties.getProperty("app.db.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static DBConnection getDBConnection(){
        if(dbConnection==null) dbConnection = new DBConnection();
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }

}
