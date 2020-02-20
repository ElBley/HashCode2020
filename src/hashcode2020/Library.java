/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.math.*;

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

    private int getMaxPoints(int maxDays) {

        int maxLibros = (maxDays - signUpTime) * nBooksDay;

        this.quickSort(0, books.size() - 1);

        int j = 0;
        int maxScore = 0;
        while (j < books.size() && j < maxLibros) {
            maxScore += books.get(j).score;
            j++;
        }

        return maxScore;
    }

    private void quickSort(int start, int end) {

        int partition = partition(start, end);

        if (partition - 1 > start) {
            quickSort(start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(partition + 1, end);
        }
    }

    private int partition(int start, int end) {
        Book pivot = books.get(end);

        for (int i = start; i < end; i++) {
            if (books.get(i).score > pivot.score) {
                Book temp = books.get(start);
                books.set(start, books.get(i));
                books.set(i, temp);
                start++;
            }
        }

        Book temp = books.get(start);
        books.set(start, pivot);
        books.set(end, temp);

        return start;
    }

    public Long librosEnviar(int diasUtiles) {
        
        return Math.min((long) diasUtiles * this.nBooksDay, this.books.size());
    }
}
