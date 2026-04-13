package perez.cordero.projecte_ra5_ra7.utils;

import Perez.Cordero.Fitxers;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import perez.cordero.projecte_ra5_ra7.classes.TipusAnimal;

import java.util.ArrayList;
import java.util.HashMap;

// Classe d'utilitat per gestionar els fitxers binaris (.dat)
// Tots els metodes son static per poder-los cridar sense instanciar la classe
public class GestioFitxers {

    // Ruta del fitxer d'usuaris
    private static final String RUTA_USUARIS = "fitxers/usuaris.dat";

    // Retorna la ruta del fitxer segons el tipus d'animal
    public static String rutaFitxer(TipusAnimal tipus) {
        switch (tipus) {
            case VACA:    return "fitxers/vaques.dat";
            case GALLINA: return "fitxers/gallines.dat";
            case POLP:    return "fitxers/polps.dat";
            case PEIX:    return "fitxers/peixos.dat";
            default:      return "fitxers/animals.dat";
        }
    }

    // Mètode privat compartit: guarda qualsevol objecte en un fitxer binari
    // El fan servir tant guardarAnimal com guardarUsuari
    private static void guardar(Object obj, String ruta) {
        new Fitxers(ruta).guardarObjecte(obj);
    }

    // Guarda un animal al fitxer corresponent al seu tipus
    public static void guardarAnimal(Animal a) {
        String ruta = rutaFitxer(a.getTipus());
        ArrayList<Animal> llista = llegir(ruta);
        llista.add(a);
        guardar(llista, ruta);  // usa el mètode compartit
    }

    // Guarda un usuari nou al fitxer d'usuaris
    public static void guardarUsuari(String user, String pass) {
        HashMap<String, String> usuaris = llegirUsuaris();
        usuaris.put(user, pass);
        guardar(usuaris, RUTA_USUARIS);  // usa el mètode compartit
    }

    // Elimina un animal pel seu nom dins d'un fitxer
    public static void eliminarAnimal(String nom, String ruta) {
        ArrayList<Animal> llista = llegir(ruta);
        llista.removeIf(a -> a.getNom().equals(nom));
        guardar(llista, ruta);
    }

    // Llegeix una llista d'animals d'un fitxer, retorna llista buida si no existeix
    public static ArrayList<Animal> llegir(String ruta) {
        Object obj = new Fitxers(ruta).llegirObjecte();
        if (obj == null) return new ArrayList<>();
        return (ArrayList<Animal>) obj;
    }

    // Llegeix el mapa d'usuaris del fitxer, retorna mapa buit si no existeix
    public static HashMap<String, String> llegirUsuaris() {
        Object obj = new Fitxers(RUTA_USUARIS).llegirObjecte();
        if (obj == null) return new HashMap<>();
        return (HashMap<String, String>) obj;
    }
}