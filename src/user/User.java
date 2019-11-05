/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import album.Album;
import java.util.ArrayList;

/**
 *
 * @author Davyson
 */
public class User {
    
    private int id;
    private String email;
    private String password;
    private String name;
    private ArrayList<Album> libraries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Album> getLibraries() {
        return libraries;
    }

    public void setLibraries(ArrayList<Album> libraries) {
        this.libraries = libraries;
    }
}
