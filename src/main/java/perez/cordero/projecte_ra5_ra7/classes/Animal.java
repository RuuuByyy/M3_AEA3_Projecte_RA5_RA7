package perez.cordero.projecte_ra5_ra7.classes;


import java.io.Serializable;

public abstract class Animal implements Serializable {

    protected String nom;
    protected int edat;
    protected TipusAnimal tipus;
    protected Habitat habitat;
    protected int vitalitat;

    public Animal(String nom, int edat, TipusAnimal tipus, Habitat habitat) {
        this.nom = nom;
        this.edat = edat;
        this.tipus = tipus;
        this.habitat = habitat;
        this.vitalitat = 100;
    }

    public String getNom() { return nom; }
    public TipusAnimal getTipus() { return tipus; }
    public Habitat getHabitat() { return habitat; }
    public int getEdat() { return edat; }
    public int getVitalitat() { return vitalitat; }

    public void setVitalitat(int vitalitat) {
        this.vitalitat = Math.max(0, Math.min(100, vitalitat));
    }

    public int descansar() {
        int recuperat = 20;
        setVitalitat(vitalitat + recuperat);
        return recuperat;
    }

    public abstract String ferSo();

    @Override
    public String toString() {
        return nom + " - " + tipus + " - " + edat + " anys - Vitalitat: " + vitalitat;
    }
}