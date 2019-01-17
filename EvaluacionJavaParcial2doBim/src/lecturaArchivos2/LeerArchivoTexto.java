package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo(String nombre) {

        try {
            nombre = nombre;
            entrada = new Scanner(new File(nombre));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo txt
    public ArrayList<Profesor> leerRegistros2() {

        OperacionData operacion = new OperacionData();
        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                // se crea el objeto para leer Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p);
                //System.out.println(p);

            } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n
    
    // leer registro del archivo csv
    public ArrayList<Profesor> leerRegistros1() {
        ArrayList<Profesor> lista = new ArrayList<>(); // se crea una nueva lista vacia
        try { 
            String cadena = entrada.nextLine();
            while (entrada.hasNext()) {
                cadena = entrada.nextLine();
                ArrayList<String> lineas = new ArrayList<String>(Arrays.asList(cadena.split(","))); // se usa el esplit para separar la cadena
                Profesor persona = new Profesor(); // se crea un nuevo obejto al cual se le asignara cada elemento de la cadena anteriormente separada en la lista
                persona.setCedula(lineas.get(0)); // se agrega la cedula
                persona.setNombres(lineas.get(1)); // se agrega los nombres 
                persona.setZona(lineas.get(2)); // se agrega la zona 
                persona.setProvincia(lineas.get(3)); // se agrega la provincia
                persona.setCanton(lineas.get(4)); // se agrega el canton
                persona.setPersonalidad(lineas.get(5)); // se agrega la personalidad
                persona.setRazonamiento(lineas.get(6)); // se agrega el razonamiento
                persona.setDictamenIdoniedad(lineas.get(7)); // se agrega la dictemenIdoniedad

                lista.add(persona); // se agrega toda la informacion que contiene el objeto persona a la lista
            }
            // fin while
        // fin try
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

/**
 * ************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y * Pearson Education,
 * Inc. Todos los derechos reservados. * * RENUNCIA: Los autores y el editor de
 * este libro han realizado su mejor * esfuerzo para preparar este libro. Esto
 * incluye el desarrollo, la * investigaci�n y prueba de las teor�as y programas
 * para determinar su * efectividad. Los autores y el editor no hacen ninguna
 * garant�a de * ning�n tipo, expresa o impl�cita, en relaci�n con estos
 * programas o * con la documentaci�n contenida en estos libros. Los autores y
 * el * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de * estos
 * programas. *
 * ***********************************************************************
 */
