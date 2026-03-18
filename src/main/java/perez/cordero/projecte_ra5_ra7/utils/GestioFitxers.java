package perez.cordero.projecte_ra5_ra7.utils;


import Perez.Cordero.Fitxers;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import perez.cordero.projecte_ra5_ra7.classes.TipusAnimal;

import java.util.ArrayList;

public class GestioFitxers {

    public static String rutaFitxer(TipusAnimal tipus) {
        switch (tipus) {
            case VACA: return "fitxers/vaques.dat";
            case GALLINA: return "fitxers/gallines.dat";
            case POLP: return "fitxers/polps.dat";
            case PEIX: return "fitxers/peixos.dat";
            default: return "fitxers/animals.dat";
        }
    }

    public static void guardarAnimal(Animal a) {

        String ruta = rutaFitxer(a.getTipus());

        ArrayList<Animal> llista = llegir(ruta);
        llista.add(a);

        new Fitxers(ruta).guardarObjecte(llista);
    }

    public static void eliminarAnimal(String nom, String ruta) {
        ArrayList<Animal> llista = llegir(ruta);
        llista.removeIf(a -> a.getNom().equals(nom));
        new Fitxers(ruta).guardarObjecte(llista);
    }

    public static ArrayList<Animal> llegir(String ruta) {

        Object obj = new Fitxers(ruta).llegirObjecte();

        if (obj == null) return new ArrayList<>();

        return (ArrayList<Animal>) obj;
    }
}