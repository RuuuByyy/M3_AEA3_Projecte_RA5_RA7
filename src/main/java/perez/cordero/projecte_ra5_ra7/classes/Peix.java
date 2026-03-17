package perez.cordero.projecte_ra5_ra7.classes;


import perez.cordero.projecte_ra5_ra7.interfaces.AccionsAnimals;

public class Peix extends Animal implements AccionsAnimals {

    public Peix(String nom, int edat) {
        super(nom, edat, TipusAnimal.PEIX, Habitat.AIGUA);
    }

    public String ferSo() { return "Blub"; }

    public void caminar() {}
    public void nadar() {}
    public void volar() {}
}