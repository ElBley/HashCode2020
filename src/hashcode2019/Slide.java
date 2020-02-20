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
public class Slide {
    
    private ArrayList<Photo> photos;
    private ArrayList<String> tags;
    
    public Slide(Photo p1){
        photos = new ArrayList<>(1);
        if(p1.getType() == 'H'){
            photos.add(p1);
            calcularTags();
        }
    }
    
    public Slide(Photo p1, Photo p2){
        photos = new ArrayList<>(2);
        if(p1.getType() == 'V' && p2.getType() == 'V'){
            photos.add(p1);
            photos.add(p2);
            calcularTags();
        }
    }
    
    private void calcularTags(){
        tags = new ArrayList<>();
        
        for(Photo p : photos){
            
            for(String s : p.getTags()){
                if(!tags.contains(s)){
                    tags.add(s);
                }
            }
        }
    }

    public ArrayList<String> getTags() {
        return tags;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        for(Photo p : photos){
            toret.append(p.getId()).append(" ");
        }
        
        return toret.toString().trim();
    }
}
