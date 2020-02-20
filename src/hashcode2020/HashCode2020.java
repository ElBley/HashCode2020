/* ESPAÑA
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.io.*;
import java.util.*;

/**
 *
 * @author Equipo UwU
 */
public class HashCode2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter fw = null;
        PrintWriter salida = null;

        try {

            ArrayList<ArrayList<Book>> librosBibliotecas = new ArrayList<ArrayList<Book>>();
            
            
            File fichero = new File(args[0]);
            File ficheroSalida = new File("Salida.out");

            fw = new FileWriter(ficheroSalida);
            salida = new PrintWriter(fw);
            
            
            
           Scanner entrada = new Scanner(fichero);

           String [] aux = entrada.nextLine().split(" "); 
           
           int nLibros = Integer.parseInt(aux[0]);
           int nBibliotecas = Integer.parseInt(aux[1]);
           int nDias = Integer.parseInt(aux[2]);
           
           //indice es el id, y el array tiene la puntuacion
           ArrayList<Book> puntuacionLibros = new ArrayList<Book>(nLibros);
           aux = entrada.nextLine().split(" ");
           
           for(int i = 0; i<nLibros;i++){
               puntuacionLibros.add(new Book(i,Integer.parseInt(aux[i])));
           }
           
           ArrayList<Library> listaBibliotecas = new ArrayList<Library>(nBibliotecas);
           int nLibrosBibliotecaAux;
           int signUpAux;
           int booksPerDayAux;
           
           ArrayList<Book> librosPorBiblioteca;
           
           
           for(int i = 0; i<nBibliotecas;i++){
               aux = entrada.nextLine().split(" ");
               
               nLibrosBibliotecaAux = Integer.parseInt(aux[0]);
               signUpAux = Integer.parseInt(aux[1]);
               booksPerDayAux = Integer.parseInt(aux[2]);
               
                
               librosPorBiblioteca = new ArrayList<Book>(nLibrosBibliotecaAux);
               
               aux = entrada.nextLine().split(" ");
               for(int j=0;j<nLibrosBibliotecaAux;j++){
                   librosPorBiblioteca.add(puntuacionLibros.get(Integer.parseInt(aux[j])));
               }
               listaBibliotecas.add(new Library(i,signUpAux,booksPerDayAux,librosPorBiblioteca,nDias));
           }
           
           
           
           
           Container master = new Container(listaBibliotecas,puntuacionLibros,nDias);
           
            System.out.println(master.toString());
           
           
           
            
            salida.print("texto de ejemplo \n");
            
            


            fw.close();

        } catch (Exception exc) {
            System.err.println(exc);
        } finally {

        }

    }
}
