/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.util.ArrayList;

/**
 *
 * @author cgmr2
 */
public class Library {
    private int id;
    private ArrayList<Book> books;
    private int signUpTime;
    private int nBooksDay;

    public Library(int id, int signUpTime, int nBooksDay, ArrayList<Book> books) {
        this.id = id;
        this.signUpTime = signUpTime;
        this.nBooksDay = nBooksDay;
        this.books = books;
    }
    
     
    
}
