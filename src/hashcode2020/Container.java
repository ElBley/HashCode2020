/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.io.*;
import java.util.*;

/**
 *
 * @author Team UwU
 */
public class Container {
    
    private ArrayList<Library> listaBibliotecas;
    private ArrayList<Book> listaLibrosTotales;
    private int ndays;
    private ArrayList<Boolean> listaLibrosEnviados;
    

    public Container(ArrayList<Library> listaBibliotecas, ArrayList<Book> listaLibrosTotales, int ndays) {
        this.listaBibliotecas = listaBibliotecas;
        quickSort(this.listaBibliotecas,0,this.listaBibliotecas.size()-1);
        this.listaLibrosTotales = listaLibrosTotales;
        this.ndays = ndays;
        this.listaLibrosEnviados = new ArrayList<Boolean>(listaLibrosTotales.size());
        
        for(int i = 0; i< listaLibrosTotales.size();i++){
            listaLibrosEnviados.add(Boolean.FALSE);
        }
    }
    
    public void ordenarBibliotecas(){
        ArrayList<Library> aux = new ArrayList<Library>();
        
    }
    
     private static void quickSort(ArrayList<Library> arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    private static int partition(ArrayList<Library> arr, int start, int end){
        Library pivot = arr.get(end);
 
        for(int i=start; i<end; i++){
            if(arr.get(i).maxPoints>pivot.maxPoints){
                Library temp= arr.get(start);
                arr.set(start, arr.get(i));
                arr.set(i,temp);
                start++;
            }
        }
 
        Library temp = arr.get(start);
        arr.set(start,  pivot);
        arr.set(end, temp);
 
        return start;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        int acumulador = this.ndays;
        
        int diaSuma = 0;
        int nBibl = 0;
        for( nBibl = 0; nBibl<listaBibliotecas.size() && diaSuma < this.ndays;nBibl++){
            diaSuma += listaBibliotecas.get(nBibl).signUpTime;
        }
        if(diaSuma > this.ndays){
            nBibl--;
        }
        toret.append(nBibl).append("\n");
        
        for(int  i= 0; i<nBibl; i++){
            acumulador -= this.listaBibliotecas.get(i).signUpTime;
            toret.append(this.listaBibliotecas.get(i).id).append(" ");
            long nLibros =  this.listaBibliotecas.get(i).librosEnviar(acumulador);
            toret.append(nLibros).append("\n");
            
            
           for(int j=0;j<nLibros;j++){
               toret.append(this.listaBibliotecas.get(i).books.get(j).id).append(" ");
           }
           toret.append("\n");
        }
        
        
        return toret.toString();
    }
    
}
