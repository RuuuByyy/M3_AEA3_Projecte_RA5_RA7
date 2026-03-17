package perez.cordero.projecte_ra5_ra7.classes;


import perez.cordero.projecte_ra5_ra7.interfaces.AccionsAnimals;

public class Vaca extends Animal implements AccionsAnimals {

    public Vaca(String nom, int edat) {
        super(nom, edat, TipusAnimal.VACA, Habitat.TERRA);
    }

    public int munyir() {
        return 10;
    }

    public String ferSo() { return "Muuu"; }

    public void caminar() {}
    public void nadar() {}
    public void volar() {}
}