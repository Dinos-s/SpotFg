/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Davyson
 */
public class SqlConnection {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public Statement connect() throws SQLException, Exception{
        String server = "jdbc:postgresql://localhost/spotfg?charSet=LATIN1";
        String user = "postgres";
        String password = "";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        
        this.connection = DriverManager.getConnection(server, user, password);
        return this.connection.createStatement();
        
    }
    
    public void disconnect() throws SQLException{
        this.connection.close();
    }
    
    public Connection connectParameters() throws Exception{
        connect();
        return this.connection;
    }
    
}
