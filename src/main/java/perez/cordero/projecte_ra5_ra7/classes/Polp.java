package perez.cordero.projecte_ra5_ra7.classes;

import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

public class Polp extends Animal implements AccionsAnimals {

    public Polp(String nom, int edat) {
        super(nom, edat, TipusAnimal.POLP, Habitat.AIGUA);
    }

    public String ferSo() { return "Glup"; }

    public int caminar() { int p = 15; setVitalitat(vitalitat - p); return -p; }
    public int nadar() { int p = 3; setVitalitat(vitalitat - p); return -p; }
    public int volar() { int p = 25; setVitalitat(vitalitat - p); return -p; }
}