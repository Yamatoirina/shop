package com.shop.dao;

import com.shop.dao.connection.DatabaseConnection;
import com.shop.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection = DatabaseConnection.getDBConnection();
    private Logger logger = LoggerFactory.getLogger(this.getClass());




    public User getUserByUsername( String username){
        PreparedStatement stmt = null;
        User user = null;

        try{
            String sql = "SELECT * FROM users where USERNAME = ?";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1,username);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                String usrName = rs.getString("USERNAME");
                String pswd = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");

                if (usrName !=null && pswd != null && role != null){
                    user = new User(usrName, pswd,role);
                } else return null;
            }

        } catch (SQLException e) {
            logger.error("Error", e);
        } finally {
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

public void createUserBy(String username, String password){
        PreparedStatement stmt = null;
        try{
            String sql = "INSERT INTO users(USERNAME, PASSWORD) VALUES(?, ?)";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1,username);
            stmt.setString(2, password);

            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error", e);
        } finally {
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}


    public User getUserByUserNameAndPassword( String username, String password ) {
        User user = null;

return user;
    }
}
