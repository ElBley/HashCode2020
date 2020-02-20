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
 * @author Brais
 */
public class HashCodePizzaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter fw = null;
        PrintWriter salida = null;

        try {
            int nSlices = 0;
            int nTipos = 0;
            String aux;
            String [] array;

            File fichero = new File(args[0]);
            File ficheroSalida = new File("Salida.out");

            fw = new FileWriter(ficheroSalida);
            salida = new PrintWriter(fw);
            
            
            
            Scanner entrada = new Scanner(fichero);
            
            
            aux = entrada.nextLine();
            nSlices = Integer.parseInt(aux.split(" ")[0]);
            nTipos = Integer.parseInt(aux.split(" ")[1]);
            
            ArrayList<Integer> lista = new ArrayList<Integer>(nTipos);
            
            aux = entrada.nextLine();            
            array = aux.split(" ");
            for(int i = 0; i<nTipos;i++){
                
                lista.add(Integer.parseInt(array[i]));
            }
                
            ArrayList<Integer> toret = CalcularPizzas.calcularPizzas(nSlices,lista);
            
            
            salida.print(toret.size() + "\n");
            
            ListIterator<Integer> itr = toret.listIterator(toret.size());
            while(itr.hasPrevious()){
                salida.print(itr.previous() + " ");
            }
            


            fw.close();

        } catch (Exception exc) {
            System.err.println(exc);
        } finally {

        }

    }
}

