/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author cgmr2
 */
public class Library {
    public int id;
    public ArrayList<Book> books;
    public int signUpTime;
    public int nBooksDay;
    public int maxPoints;

    public Library(int id, int signUpTime, int nBooksDay, ArrayList<Book> books, int maxDays) {
        this.id = id;
        this.signUpTime = signUpTime;
        this.nBooksDay = nBooksDay;
        this.books = books;
        this.maxPoints = getMaxPoints(maxDays);
    }
    
    private int getMaxPoints(int maxDays){
        
        int maxLibros = (maxDays - signUpTime) * nBooksDay;
        
        int[] scores = new int[books.size()];
        for (int i = 0; i < books.size(); i++) {
            scores[i] = books.get(i).score;
        }
        
        Arrays.sort(scores);
        
        int j = 0;
        int maxScore = 0;
        while(j<scores.length && j<maxLibros){
            maxScore += scores[j];
        }
        
        return maxScore;
    }
     
    
}
