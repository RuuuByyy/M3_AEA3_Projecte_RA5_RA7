package perez.cordero.projecte_ra5_ra7.classes;

import perez.cordero.projecte_ra5_ra7.interfaces.AccionsAnimals;

public class Gallina extends Animal implements AccionsAnimals {

    public Gallina(String nom, int edat) {
        super(nom, edat, TipusAnimal.GALLINA, Habitat.TERRA);
    }

    public String ferSo() { return "Coco"; }

    public void caminar() {}
    public void nadar() {}
    public void volar() {}
}