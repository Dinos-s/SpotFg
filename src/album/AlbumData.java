/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album;

import connection.SqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Davyson
 */
public class AlbumData extends SqlConnection{
    
    public void insertAlbum(Album a) throws SQLException, Exception{
        
        String query = "INSERT INTO albuns (nome, artista, genero) VALUES (?,?,?)";
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        statement.setString(1, a.getName());
        statement.setString(2, a.getArtist());
        statement.setString(3, a.getGenre());
        
        statement.executeUpdate();
        
        disconnect();
        
    }
    
    public ArrayList<Album> selectAllAlbuns(Album a) throws SQLException, Exception{
        
        ArrayList<Album> albumList = new ArrayList<>();
        
        String query = "SELECT nome, genero, artista FROM albuns Order by nome";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            albumList.add(al);
        }
        
        return albumList;
        
    }
    
    public Album selectAlbumByName(Album a) throws SQLException, Exception{
        
        Album al = new Album();
        
        String query = "SELECT nome, genero, artista FROM albuns WHERE nome like %?%";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        statement.setString(1, a.getName());
        
        ResultSet resultSet = statement.executeQuery();
        
        al.setName(resultSet.getString("nome"));
        al.setGenre(resultSet.getString("genero"));
        al.setArtist(resultSet.getString("artista"));
        
        return al;
    }
    
    public ArrayList<Album> selectAlbumByArtist(Album a) throws SQLException, Exception{
        
        ArrayList<Album> albumList = new ArrayList<>();
        int position = 1;
        
        String query = "SELECT nome, genero, artista FROM albuns WHERE artista like %?%";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        statement.setString(0, query);
        
    }
    
}
