/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2020;

import java.util.*;

/**
 *
 * @author Brais
 */
public class CalcularPizzas {

    public static ArrayList<Integer> calcularPizzas(int nSlices, ArrayList<Integer> lista) {

        ArrayList toret = new ArrayList<Integer>();
        int acumulador = 0;
        int valorMej = 0;
        ArrayList aux = new ArrayList<Integer>();

        for (int i = lista.size() - 1; i >= 0; i--) {
            acumulador += lista.get(i);
            aux.add(i);            
            if (acumulador > valorMej && acumulador <= nSlices) {
                valorMej = acumulador;
                toret = (ArrayList<Integer>) aux.clone();
            }
            if (acumulador > nSlices) {
                aux.remove(aux.size()-1);
                acumulador -= lista.get(i);
            }
            if (acumulador == nSlices) {
                break;
            }
        }

        return toret;
    }

}
