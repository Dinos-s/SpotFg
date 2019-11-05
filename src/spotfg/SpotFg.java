/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotfg;

import album.Album;
import album.AlbumData;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Davyson
 */
public class SpotFg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner s = new Scanner(System.in);
        
        AlbumData ab = new AlbumData();
        ArrayList<Album> al;
        
        
        try {
            al = ab.selectAlbumByGenre("rock");
            
            for (int i = 0; i < al.size(); i++) {
                Album a = new Album();
                a.setId(al.get(i).getId());
                a.setName(al.get(i).getName());
                a.setArtist(al.get(i).getArtist());
                a.setGenre(al.get(i).getGenre());
                a.setCover(al.get(i).getCover());
                System.out.println(a.getId() + " " + a.getName() + " " + a.getArtist() + " " + a.getGenre() + " " + a.getCover());
            }
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
        
        
    }
    
}
