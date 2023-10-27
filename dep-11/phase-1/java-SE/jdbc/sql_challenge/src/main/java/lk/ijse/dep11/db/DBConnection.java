package lk.ijse.dep11.db;

import lombok.Data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.Properties;

@Data
public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;

    private DBConnection() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/application.properties"));
        String url=properties.getProperty("app.db.url");
        String username = properties.getProperty("app.db.username");
        String passwd = properties.getProperty("app.db.password");
        try {
            connection = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getDbConnection(){
        if(dbConnection==null){
            try {
                dbConnection = new DBConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
