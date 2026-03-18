package perez.cordero.projecte_ra5_ra7.classes;

// Importamos la interfaz que define las acciones obligatorias para los animales.
import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

/**
 * Clase Gallina: Hereda de Animal (Extends) y debe cumplir el contrato de AccionsAnimals (Implements).
 * Esto es un ejemplo claro de Herencia y Polimorfismo en Java.
 */
public class Gallina extends Animal implements AccionsAnimals {

    // Constructor de Gallina.
    // Al ser una clase hija, usamos 'super' para pasar los datos al constructor de la clase padre (Animal).
    public Gallina(String nom, int edat) {
        // Definimos de forma fija que es de tipo GALLINA y su hábitat es TERRA.
        super(nom, edat, TipusAnimal.GALLINA, Habitat.TERRA);
    }

    // Implementación obligatoria del método abstracto de la clase Animal.
    public String ferSo() { return "Coco"; }

    // --- Implementación de los métodos de la Interfaz AccionsAnimals ---

    // Al caminar, definimos un gasto de energía (p = 5).
    // Usamos setVitalitat (de la clase padre) para actualizar el estado del animal.
    public int caminar() { int p = 5; setVitalitat(vitalitat - p); return -p; }

    // Al nadar, la gallina se cansa mucho más (p = 20).
    public int nadar() { int p = 20; setVitalitat(vitalitat - p); return -p; }

    // Al volar, tiene un gasto intermedio (p = 10).
    public int volar() { int p = 10; setVitalitat(vitalitat - p); return -p; }
}