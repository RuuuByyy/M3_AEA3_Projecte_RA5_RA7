package perez.cordero.projecte_ra5_ra7.classes;


import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

public class Vaca extends Animal implements AccionsAnimals {

    private int llet;

    public Vaca(String nom, int edat) {
        super(nom, edat, TipusAnimal.VACA, Habitat.TERRA);
        this.llet = 0;
    }

    public int munyir() {
        int punts = 10;
        llet += punts;
        return punts;
    }

    public int getLlet() { return llet; }

    public String ferSo() { return "Muuu"; }

    public int caminar() { int p = 5; setVitalitat(vitalitat - p); return -p; }
    public int nadar() { int p = 15; setVitalitat(vitalitat - p); return -p; }
    public int volar() { int p = 25; setVitalitat(vitalitat - p); return -p; }
}