/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;
import java.io.FileNotFoundException;              
import java.lang.SecurityException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

/**
 *
 * @author David Lopez
 */
public class CrearArchivo {
    public  Formatter salida;
    public void abrirArchivo() { // metodo para poder abrir el archivo
        try {   
            salida = new Formatter("data/ListaOrdenadaPorNombres.csv"); // le decimos donde guardar el nuevo archivo
        } // fin de try
        catch (SecurityException securityException) { // Execepciones que se pueden presentar 
            System.err.println("No tiene acceso de escritura a este archivo."); 
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {  // Execepciones que se pueden presentar
            System.err.println("Error al crear el archivo."); 
            System.exit(1);
        } // fin de catch
    }

    public void agregarRegistros(ArrayList<Profesor> lista) { // Metodo para Agregar registros al archivo
        try {               // lineas que tratamos de ejecutar pero pueden presentar un error
            for (int i = 0; i < lista.size(); i++) {     // se recorre todos los elemntos
                Profesor d = lista.get(i); 
                salida.format("%s - %s - %s - %s - %s - %s - %s - %s\n", d.getCedula(), d.getNombres(), d.getZona(), d.getProvincia(), d.getCanton(), d.getPersonalidad(),d.getRazonamiento(), d.getDictamenIdoniedad());
            }       // Escribimos en el archivo segun el tipo de formato mostrado
        } catch (FormatterClosedException formatterClosedException) { //Excepciones que podrian presentarse
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
        } // fin de catch

    } 
    public void cerrarArchivo() {      
        if (salida != null) {
            salida.close();         
        }
    }  
    
}
