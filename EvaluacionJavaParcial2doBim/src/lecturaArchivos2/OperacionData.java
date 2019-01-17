/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author reroes
 */
public class OperacionData {

    ArrayList<Profesor> informacion = new ArrayList<>();

    public void agregarInformacion(ArrayList<Profesor> info) {
        informacion = info;
        //informacion = new ArrayList<Profesor>(info.subList(1, 4));
    }

    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }
    
    // Me todo para contar a los participantes por personalidad
    public void NumeroParticipantesPersonalidad() {
        // se declara las variables
        int num_adecuado = 0;
        int num_convocar = 0;

        for (int i = 0; i < this.informacion.size(); i++) { // se recorre 
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) {
                num_adecuado = num_adecuado + 1; // se suma al contador
            } else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                num_convocar = num_convocar + 1; // se suma al contador
            }
        }
        // se imprime los resultados
        System.out.printf("El numero de personas con personalidad adecuada es de %d\n", num_adecuado);
        System.out.printf("El numero de personas con personalidad por convocar es de %d\n", num_convocar);

    }

    // metodo para contar el numero de participantes por dictamendeidoneidad
    public void NumeroParticipantesDictamendeIdoneidad() {
        // se declara nuevas variables
        int num_idoneo = 0;
        int num_no_idoneo = 0;

        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                num_idoneo = num_idoneo + 1; // se suma el contador
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                num_no_idoneo = num_no_idoneo + 1; // se suma el contador
            }
        }
        // se imprime los resultados  
        System.out.printf("El numero de personas con DictamenIdoniedad adecuada es de %d\n", num_idoneo);
        System.out.printf("El numero de personas con DictamenIdoniedad por convocar es de %d\n", num_no_idoneo);

    }

    // proceso de ordenar, a través del uso de Collections
    public void ordenarPorCanton() {// uso para metodo para ordenar la lista por cantones 
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones,
                (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }

    // Metodo para ordenar la lista por nombres 
    public ArrayList<Profesor> ordenarPorNombres() {
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;

    }

    public void lecturaData() {
        for (int i = 0; i < obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));

        }

    }

}
