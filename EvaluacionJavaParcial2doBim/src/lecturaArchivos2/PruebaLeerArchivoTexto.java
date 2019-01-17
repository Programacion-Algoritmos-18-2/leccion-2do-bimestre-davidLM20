package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        /* se crea dos obejetos tipo LeerArchivos 
        para poder leer los dos achivos,
        tanto el txt como el csv
        */
        LeerArchivoTexto archivo_1 = new LeerArchivoTexto();
        LeerArchivoTexto archivo_2 = new LeerArchivoTexto();
        
        CrearArchivo nuevo_archivo = new CrearArchivo();
        
        OperacionData operacion = new OperacionData(); // se crea un objeto tipo operacion para porder realizar las operciones
         
        archivo_1.abrirArchivo("data/data1.csv");// se da la ruta donde se encuentra el archivo csv
        archivo_2.abrirArchivo("data/data2.txt");// se da la ruta donde se encuentra el archivo txt
        
        ArrayList<Profesor> lista_1 = archivo_1.leerRegistros1(); // se crea una nueva lista donde se guardara todos los objetos tipo profesor
        ArrayList<Profesor> lista_2 = archivo_2.leerRegistros2(); // se crea una nueva lista donde se guardara todos los objetos tipo profesor
        
        ArrayList<Profesor> lista_3 = new ArrayList<>(); // se crea una lista vacia que nos servira para guardar la informacion de las otras dos listas 
        
        // se crea dos recorridos par poder agregar la informacion a la nueva lista vacia (lista_3)
        for (int i = 0; i < lista_1.size(); i++) {
            lista_3.add(lista_1.get(i));// se agrega la informacion de la lista 1 
        }
        for (int i = 0; i < lista_2.size(); i++) {
            lista_3.add(lista_2.get(i)); // se agrega la informacion de la lista 2
        }
        operacion.agregarInformacion(lista_3); // se procede a agregar la informacion para las operaciones 
        operacion.lecturaData();
        
        //System.out.println(lista_3);     esta linea es para comprobar si lista 3 contiene los elementos de las otras 2 listas
        operacion.ordenarPorCanton(); // se toma el metodo ordenar por canto para presentar la lista ordenada por canton
        
        ArrayList<Profesor> lista_ordenada_nombres = operacion.ordenarPorNombres(); // se crea una nueva lista para ordenar por nombres 
        System.out.println("-----------------------------------------------------------------------------"); //separador
        //System.out.println(lista_ordenada_nombres); // se presenta la nueva lista ordenada por nombres
        
        
        // cantidad por personalidad
        operacion.NumeroParticipantesPersonalidad();
        //cantidad por idineidad
        operacion.NumeroParticipantesDictamendeIdoneidad();
        
        // operacion.lecturaData();
        // se crea el nuevo archivo
        nuevo_archivo.abrirArchivo();
        nuevo_archivo.agregarRegistros(lista_ordenada_nombres);
        archivo_1.cerrarArchivo();
        archivo_2.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

