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
public class HashCode2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter fw = null;
        PrintWriter salida = null;

        try {


            File fichero = new File(args[0]);
            File ficheroSalida = new File("Salida.out");

            fw = new FileWriter(ficheroSalida);
            salida = new PrintWriter(fw);
            
            
            
            Scanner entrada = new Scanner(fichero);

            
            
            salida.print("texto de ejemplo \n");
            
            


            fw.close();

        } catch (Exception exc) {
            System.err.println(exc);
        } finally {

        }

    }
}
