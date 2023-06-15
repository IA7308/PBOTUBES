package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() throws SQLException{
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplikasipromosirumah","root","iqnazgg123");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return connection;
    }

}
