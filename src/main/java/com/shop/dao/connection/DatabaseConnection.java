package com.shop.dao.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DatabaseConnection {
    private static final String URLdb = "jdbc:mysql://localhost:3306/test";
    private static final String userDB = "debian-sys-maint";
    private static final String passwordDB = "4cdc7ur5EM8Eap79";

    private static Logger logger = LoggerFactory.getLogger("DatabaseConnection");

    public static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URLdb, userDB, passwordDB);

        } catch (ClassNotFoundException | SQLException ex) {
            logger.error("Error connecting to database", ex);
            ex.printStackTrace();
        }
        return connection;
    }

}