package perez.cordero.projecte_ra5_ra7.classes;


import java.io.Serializable;

public abstract class Animal implements Serializable {

    protected String nom;
    protected int edat;
    protected TipusAnimal tipus;
    protected Habitat habitat;

    public Animal(String nom, int edat, TipusAnimal tipus, Habitat habitat) {
        this.nom = nom;
        this.edat = edat;
        this.tipus = tipus;
        this.habitat = habitat;
    }

    public String getNom() { return nom; }
    public TipusAnimal getTipus() { return tipus; }

    public abstract String ferSo();

    @Override
    public String toString() {
        return nom + " - " + tipus + " - " + edat;
    }
}