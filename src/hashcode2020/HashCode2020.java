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

            ArrayList<ArrayList<Integer>> librosBibliotecas = new ArrayList<ArrayList<Integer>>();
            
            
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
           ArrayList<Integer> puntuacionLibros = new ArrayList<Integer>(nLibros);
           aux = entrada.nextLine().split(" ");
           
           for(int i = 0; i<nLibros;i++){
               puntuacionLibros.add(Integer.parseInt(aux[i]));
           }
           
           ArrayList<ArrayList<Integer>> datosBiblioteca = new ArrayList<ArrayList<Integer>>(nBibliotecas);
           
           for(int i = 0; i<nBibliotecas;i++){
               aux = entrada.nextLine().split(" ");
               ArrayList<Integer> arrayAuxiliar = new  ArrayList<Integer>(3);
               for(int j=0;j<3;j++){
                   arrayAuxiliar.add(Integer.parseInt(aux[j]));
               }
               datosBiblioteca.add(arrayAuxiliar);
               arrayAuxiliar = new  ArrayList<Integer>(datosBiblioteca.get(i).get(0));
               
               aux = entrada.nextLine().split(" ");
               for(int j=0;j<datosBiblioteca.get(i).get(0);j++){
                   arrayAuxiliar.add(Integer.parseInt(aux[j]));
               }
               librosBibliotecas.add(arrayAuxiliar);
           }
           
           
           
           
           
            
            salida.print("texto de ejemplo \n");
            
            


            fw.close();

        } catch (Exception exc) {
            System.err.println(exc);
        } finally {

        }

    }
}
