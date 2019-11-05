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
    
    public ArrayList<Album> selectAllAlbuns() throws SQLException, Exception{
        
        ArrayList<Album> albumList = new ArrayList<>();
        
        String query = "SELECT id, nome, genero, artista, capa_url FROM albuns Order by nome";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setId(resultSet.getInt("id"));
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            al.setCover(resultSet.getString("capa_url"));
            albumList.add(al);
        }
        
        return albumList;
        
    }
    
    public ArrayList<Album> selectAlbumByName(String s) throws SQLException, Exception{
        
        ArrayList<Album> albumList = new ArrayList<>();
        
        String query = "SELECT id, nome, genero, artista, capa_url FROM albuns WHERE nome like ?";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        statement.setString(1, s);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setId(resultSet.getInt("id"));
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            al.setCover(resultSet.getString("capa_url"));
            albumList.add(al);
        }
        
        return albumList;
    }
    
    public ArrayList<Album> selectAlbumByArtist(String s) throws SQLException, Exception{
        
        ArrayList<Album> albumList = new ArrayList<>();
        
        
        String query = "SELECT id, nome, genero, artista, capa_url FROM albuns WHERE artista like ?";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setId(resultSet.getInt("id"));
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            al.setCover(resultSet.getString("capa_url"));
            albumList.add(al);
        }
        return albumList;
    }
    
    public ArrayList<Album> selectUserLibrary(String s) throws SQLException, Exception{
        ArrayList<Album> albumList = new ArrayList<>();
        
        String query = "select (l.album_id, a.nome, a.artista, a.genero, a.capa_url) from albuns as a inner join libraries as l on a.id = ?";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setId(resultSet.getInt("id"));
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            al.setCover(resultSet.getString("capa_url"));
            albumList.add(al);
        }
        
        return albumList;
    }
    
    public ArrayList<Album> selectAlbumByGenre(String s) throws SQLException, Exception{
        ArrayList<Album> albumList = new ArrayList<>();
        
        String query = "SELECT * FROM albuns WHERE genero like ?";
        
        PreparedStatement statement = connectParameters().prepareStatement(query);
        
        statement.setString(1, s);
        
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            Album al = new Album();
            al.setId(resultSet.getInt("id"));
            al.setName(resultSet.getString("nome"));
            al.setGenre(resultSet.getString("genero"));
            al.setArtist(resultSet.getString("artista"));
            al.setCover(resultSet.getString("capa_url"));
            albumList.add(al);
        }
        
        return albumList;
    }
    
}
