/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import connection.SqlConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Davyson
 */
public class UserData extends SqlConnection{
    
    public void insertUser(User u) throws SQLException, Exception{
        String query = "INSERT INTO users (email, senha, nome) VALUES(?,?,?)";
        PreparedStatement statement = connectParameters().prepareStatement(query);
        statement.setString(1, u.getEmail());
        statement.setString(2, u.getPassword());
        statement.setString(3, u.getName());
        
        statement.executeUpdate();
        
        disconnect();
    }
    
    public void updateUser(User u) throws SQLException, Exception{
        String query = "UPDATE users SET senha like ? WHERE id = ?";
        PreparedStatement statement = connectParameters().prepareStatement(query);
        statement.setString(1, u.getPassword());
        
        statement.executeUpdate();
        
        disconnect();
    }
    
    public void deleteUser(User u) throws SQLException, Exception{
        String query = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connectParameters().prepareStatement(query);
        statement.setInt(1, u.getId());
        
        statement.executeUpdate();
        
        disconnect();
    }
    
}
