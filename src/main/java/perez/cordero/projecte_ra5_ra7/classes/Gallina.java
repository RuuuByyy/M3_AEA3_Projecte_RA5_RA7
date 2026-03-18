package perez.cordero.projecte_ra5_ra7.classes;

import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

public class Gallina extends Animal implements AccionsAnimals {

    public Gallina(String nom, int edat) {
        super(nom, edat, TipusAnimal.GALLINA, Habitat.TERRA);
    }

    public String ferSo() { return "Coco"; }

    public int caminar() { int p = 5; setVitalitat(vitalitat - p); return -p; }
    public int nadar() { int p = 20; setVitalitat(vitalitat - p); return -p; }
    public int volar() { int p = 10; setVitalitat(vitalitat - p); return -p; }
}