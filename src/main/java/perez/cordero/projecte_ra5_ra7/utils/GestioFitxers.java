package perez.cordero.projecte_ra5_ra7.utils;

// Importaciones de la librería externa para manejo de ficheros y las clases del proyecto
import Perez.Cordero.Fitxers;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import perez.cordero.projecte_ra5_ra7.classes.TipusAnimal;

import java.util.ArrayList;

/**
 * Clase de utilidad para centralizar la gestión de archivos binarios (.dat).
 * Todos los métodos son 'static' para poder usarlos sin instanciar la clase.
 */
public class GestioFitxers {

    /**
     * Método auxiliar que devuelve la ruta del archivo según el tipo de animal.
     * Ayuda a organizar los datos en archivos separados por especie.
     */
    public static String rutaFitxer(TipusAnimal tipus) {
        switch (tipus) {
            case VACA: return "fitxers/vaques.dat";
            case GALLINA: return "fitxers/gallines.dat";
            case POLP: return "fitxers/polps.dat";
            case PEIX: return "fitxers/peixos.dat";
            default: return "fitxers/animals.dat";
        }
    }

    /**
     * Guarda un objeto Animal en su archivo correspondiente.
     * Sigue la lógica de: Leer lista actual -> Añadir nuevo -> Sobrescribir archivo.
     */
    public static void guardarAnimal(Animal a) {
        // Obtenemos la ruta correcta según el tipo de animal que sea el objeto 'a'
        String ruta = rutaFitxer(a.getTipus());

        // Leemos lo que ya hay en ese archivo para no borrar los animales anteriores
        ArrayList<Animal> llista = llegir(ruta);
        // Añadimos el nuevo animal a la lista cargada
        llista.add(a);

        // Usamos la clase Fitxers para guardar toda la lista actualizada en el archivo
        new Fitxers(ruta).guardarObjecte(llista);
    }

    /**
     * Elimina un animal buscando por su nombre dentro de un archivo específico.
     */
    public static void eliminarAnimal(String nom, String ruta) {
        // Cargamos la lista completa del archivo
        ArrayList<Animal> llista = llegir(ruta);

        // Usamos un predicado (Lambda) para eliminar todos los animales cuyo nombre
        // coincida con el que pasamos por parámetro.
        llista.removeIf(a -> a.getNom().equals(nom));

        // Volvemos a guardar la lista (ahora más corta) en el archivo
        new Fitxers(ruta).guardarObjecte(llista);
    }

    /**
     * Lee un archivo y devuelve una lista de objetos Animal.
     * @return Una lista con los animales o una lista vacía si el archivo no existe/está vacío.
     */
    public static ArrayList<Animal> llegir(String ruta) {

        // Intentamos leer el objeto desde el archivo binario
        Object obj = new Fitxers(ruta).llegirObjecte();

        // Control de errores: si no hay nada o el archivo no existe, devolvemos una lista vacía para evitar NullPointerException
        if (obj == null) return new ArrayList<>();

        // Hacemos un casting seguro del objeto genérico a una lista de Animales
        return (ArrayList<Animal>) obj;
    }
}