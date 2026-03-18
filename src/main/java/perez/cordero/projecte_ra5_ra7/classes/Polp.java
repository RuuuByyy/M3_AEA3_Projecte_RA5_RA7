package perez.cordero.projecte_ra5_ra7.classes;

// Importamos la interfaz que define el "contrato" de movimientos para los animales.
import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

/**
 * Clase Polp: Representa un pulpo.
 * Hereda de Animal (reutiliza atributos como nombre y edad)
 * e implementa AccionsAnimals (define cómo se mueve).
 */
public class Polp extends Animal implements AccionsAnimals {

    // Constructor de la clase Polp.
    public Polp(String nom, int edat) {
        // Llamamos al constructor del padre (Animal) pasando sus datos específicos:
        // El tipo es POLP y su hábitat natural es AIGUA.
        super(nom, edat, TipusAnimal.POLP, Habitat.AIGUA);
    }

    // Implementación del método abstracto ferSo() heredado de Animal.
    public String ferSo() { return "Glup"; }

    // --- Métodos de la interfaz AccionsAnimals ---

    // Caminar por el fondo marino le supone un esfuerzo moderado (p = 15).
    // Se actualiza la vitalidad restando este valor.
    public int caminar() { int p = 15; setVitalitat(vitalitat - p); return -p; }

    // Al ser un animal acuático, nadar es su forma más eficiente de moverse (p = 3).
    public int nadar() { int p = 3; setVitalitat(vitalitat - p); return -p; }

    // Un pulpo no puede volar, por lo que esta acción le resta muchísima vitalidad (p = 25).
    public int volar() { int p = 25; setVitalitat(vitalitat - p); return -p; }
}