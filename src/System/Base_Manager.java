package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base_Manager {
    protected static final String DB_URL = "jdbc:mysql://localhost/oopn7";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}