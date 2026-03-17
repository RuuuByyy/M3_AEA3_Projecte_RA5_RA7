package perez.cordero.projecte_ra5_ra7.classes;

import perez.cordero.projecte_ra5_ra7.interfaces.AccionsAnimals;

public class Polp extends Animal implements AccionsAnimals {

    public Polp(String nom, int edat) {
        super(nom, edat, TipusAnimal.POLP, Habitat.AIGUA);
    }

    public String ferSo() { return "Glup"; }

    public void caminar() {}
    public void nadar() {}
    public void volar() {}
}