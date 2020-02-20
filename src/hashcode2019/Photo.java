/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2019;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Photo {
    
    private char type;
    private int nTags;
    private ArrayList<String> tags;
    private int id;
    
    public Photo(char type, int nTags, ArrayList<String> tags, int id){
        this.type = type;
        this.nTags = nTags;
        this.id = id;
        
        this.tags = tags;
    }

    public char getType() {
        return type;
    }

    public int getnTags() {
        return nTags;
    }

    public ArrayList<String> getTags(){
        return tags;
    }
    
    public int getId() {
        return id;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        toret.append(getType()).append(" ").append(getnTags()).append(" ");
        for(String s : tags){
            toret.append(s).append(" ");
        }
        
        return toret.toString().trim();
    }
    
}
