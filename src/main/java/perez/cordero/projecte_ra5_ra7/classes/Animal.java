package perez.cordero.projecte_ra5_ra7.classes;

import java.io.Serializable;

// Implementa Serializable para poder guardar el objeto en un fichero .dat
public abstract class Animal implements AccionsAnimals, Serializable {

    // Propiedades comunes a todos los animales [cite: 21]
    protected String nom;
    protected int edat;
    protected int vitalitat;
    protected Habitat habitat;
    protected TipusAnimal tipus;

    public Animal(String nom, int edat, int vitalitat, Habitat habitat, TipusAnimal tipus) {
        this.nom = nom;
        this.edat = edat;
        this.vitalitat = vitalitat;
        this.habitat = habitat;
        this.tipus = tipus;
    }

    // Mètode abstracte: Cada animal se mueve diferente.
    // Obligamos a las subclases a programar este método.
    public abstract void moure();

    // Getters y Setters básicos...
    public String getNom() { return nom; }
    public TipusAnimal getTipus() { return tipus; }

    // Método común: todos pierden vitalidad al hacer esfuerzo [cite: 23]
    public void reduirVitalitat(int punts) {
        this.vitalitat -= punts;
        if(this.vitalitat < 0) this.vitalitat = 0;
    }
}