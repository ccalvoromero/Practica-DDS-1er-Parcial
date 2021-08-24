package net.dds.infrastructure.database.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DbConnector {

    public static Connection connect() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utndds?serverTimezone=UTC", "root", "ROOT");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

}