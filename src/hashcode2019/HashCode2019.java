/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2019;

import java.io.*;
import java.util.*;

/**
 *
 * @author Brais
 */
public class HashCode2019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int a = 0;
        ArrayList<Photo> album;
        String[] ufoto;
        ArrayList<String> tags;
        char tipo;
        int ntags;
        Slideshow resultado = new Slideshow();

        try {

            if (args.length != 2) {
                throw new IOException("Entrada Inválida ");
            }

            FileReader fr = new FileReader(args[0]);
            PrintWriter salida = new PrintWriter(args[1]);
            Scanner entrada = new Scanner(fr);

            a = entrada.nextInt();
            entrada.nextLine();

            album = new ArrayList<>(a);

            for (int i = 0; i < a; i++) {
                ufoto = entrada.nextLine().split(" ");
                tipo = ufoto[0].toUpperCase().charAt(0);
                ntags = Integer.parseInt(ufoto[1]);
                tags = new ArrayList<>(ntags);

                for (int j = 0; j < ntags; j++) {
                    tags.add(ufoto[j + 2]);
                }
                System.out.println("foto cargada " + i);
                album.add(new Photo(tipo, ntags, tags, i));
            }
            System.out.println("hey");
            resultado.add(album);

            salida.print(resultado.toString());

            fr.close();
            salida.close();
            entrada.close();

        } catch (Exception exc) {
           exc.printStackTrace();
        }
    }

}
