/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2019;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Alex
 */
public class Slideshow {

    private ArrayList<Slide> slides;

    public Slideshow() {
        slides = new ArrayList<>();
    }

    public void addSlide(Slide s) {
        slides.add(s);
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(slides.size()).append("\n");

        for (Slide s : slides) {
            toret.append(s).append("\n");
        }

        return toret.toString().trim();
    }

    public void add(ArrayList<Photo> album) {

        ArrayList<Photo> verticales = new ArrayList<>();
        ArrayList<Slide> auxSlides = new ArrayList<>();

        for (Photo p : album) {
            if (p.getType() == 'V') {
                verticales.add(p);
            } else {
                auxSlides.add(new Slide(p));
            }
        }
        System.out.println("preVer");
        auxSlides.addAll(agruparVerticales(verticales));
        System.out.println("posVer");
        agruparSlides(auxSlides);
    }

    private void agruparSlides(ArrayList<Slide> auxSlides) {
        //ArrayList<Slide> visitados = new ArrayList<>();
        ListIterator<Slide> itr;
        Slide act1;
        Slide act2;

        int max;
        int interest;
        Slide maxSlide = null;

        act1 = auxSlides.get(0);
        this.addSlide(act1);
        while (auxSlides.size() > 1) {
            auxSlides.remove(act1);
            //Ideal
            itr = auxSlides.listIterator();
            max = Integer.MIN_VALUE;
            while (itr.hasNext()) {
                act2 = itr.next();
                interest = getInterest(act1, act2);
                if (interest > max /*&& !visitados.contains(act2)*/) {
                    max = interest;
                    maxSlide = act2;
                }
            }
            System.out.println("slide añadido");
            this.addSlide(maxSlide);
            act1 = maxSlide;
        }
    }

    private static ArrayList<Slide> agruparVerticales(ArrayList<Photo> verticales) {
        ArrayList<Slide> toret = new ArrayList<>();
        ArrayList<Photo> visitados = new ArrayList<>();

        ListIterator<Photo> itr1 = verticales.listIterator();
        Photo act1;
        ListIterator<Photo> itr2;
        Photo act2;

        int max;
        int tagsAc;
        Photo maxPhoto = null;

        while (itr1.hasNext() && verticales.size() - visitados.size() > 1) {
            act1 = itr1.next();
            while (visitados.contains(act1) && itr1.hasNext()) {
                act1 = itr1.next();
            }
            
            if (itr1.hasNext() || !visitados.contains(act1)) {
                
                visitados.add(act1);
                max = Integer.MIN_VALUE;
                        
                itr2 = verticales.listIterator();
                while (itr2.hasNext()) {
                    
                    act2 = itr2.next();
                    while (visitados.contains(act2) && itr2.hasNext()) {
                        act2 = itr2.next();
                    }
                    
                    if(itr2.hasNext() || !visitados.contains(act2)){
                    
                        tagsAc = getTagsDiferentes(act1, act2);
                        if (max < tagsAc) {
                            max = tagsAc;
                            maxPhoto = act2;
                        }
                    }
                }

            }
            
            toret.add( new Slide(act1, maxPhoto) );
            visitados.add(maxPhoto);
        }
        
        return toret;
    }

    private static int getTagsDiferentes(Photo p1, Photo p2) {
        int cont = 0;

        for (String tag1 : p1.getTags()) {
            for (String tag2 : p2.getTags()) {
                if (tag1.equals(tag2)) {
                    cont++;
                }
            }
        }

        return p1.getnTags() + p2.getnTags() - 2 * cont;
    }

    private static int getInterest(Slide s1, Slide s2) {

        int a = 0, b = 0, c = 0;

        for (String tag1 : s1.getTags()) {
            for (String tag2 : s2.getTags()) {
                if (tag1.equals(tag2)) {
                    b++;
                } else {
                    c++;
                }
            }

        }

        a = s1.getTags().size() - b;

        return Math.min(a, Math.min(b, c));
    }
}
