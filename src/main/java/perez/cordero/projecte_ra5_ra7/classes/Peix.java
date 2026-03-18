package perez.cordero.projecte_ra5_ra7.classes;

// Importamos la interfaz que define qué acciones puede realizar cualquier animal del proyecto.
import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

/**
 * Clase Peix: Representa un pez.
 * Al extender de Animal, aprovecha sus atributos, y al implementar AccionsAnimals, define sus costes de energía.
 */
public class Peix extends Animal implements AccionsAnimals {

    // Constructor que recibe nombre y edad.
    public Peix(String nom, int edat) {
        // Llamada al constructor de la clase padre (Animal).
        // Se le asigna automáticamente el tipo PEIX y el hábitat AIGUA.
        super(nom, edat, TipusAnimal.PEIX, Habitat.AIGUA);
    }

    // Implementación del método abstracto ferSo() definido en la clase Animal.
    public String ferSo() { return "Blub"; }

    // --- Implementación de los métodos de la interfaz AccionsAnimals ---

    // Caminar para un pez es muy costoso (p = 25) ya que no es su medio natural.
    // Se resta este valor de la vitalidad heredada de la clase Animal.
    public int caminar() { int p = 25; setVitalitat(vitalitat - p); return -p; }

    // Nadar es su acción principal, por lo que el gasto de vitalidad es mínimo (p = 3).
    public int nadar() { int p = 3; setVitalitat(vitalitat - p); return -p; }

    // Volar también supone un esfuerzo máximo (p = 25) al estar fuera de su hábitat.
    public int volar() { int p = 25; setVitalitat(vitalitat - p); return -p; }
}