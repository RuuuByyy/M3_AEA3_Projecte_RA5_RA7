package perez.cordero.projecte_ra5_ra7.utils;


import fitxers.Fitxers;
import perez.cordero.projecte_ra5_ra7.classes.Animal;

import java.util.ArrayList;

public class GestioFitxers {

    public static void guardarAnimal(Animal a) {

        String ruta = "fitxers/" + a.getTipus().toString().toLowerCase() + "s.dat";

        ArrayList<Animal> llista = llegir(ruta);
        llista.add(a);

        Fitxers.guardarObjecte(ruta, llista);
    }

    public static ArrayList<Animal> llegir(String ruta) {

        Object obj = Fitxers.llegirObjecte(ruta);

        if (obj == null) return new ArrayList<>();

        return (ArrayList<Animal>) obj;
    }
}