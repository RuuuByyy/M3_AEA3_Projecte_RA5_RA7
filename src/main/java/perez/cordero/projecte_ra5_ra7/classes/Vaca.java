package perez.cordero.projecte_ra5_ra7.classes;


// Importamos la interfaz que define los movimientos comunes de los animales.
import perez.cordero.projecte_ra5_ra7.classes.AccionsAnimals;

/**
 * Clase Vaca: Hereda de Animal e implementa AccionsAnimals.
 * Además, introduce un atributo propio para gestionar la producción de leche.
 */
public class Vaca extends Animal implements AccionsAnimals {

    // Atributo específico de la clase Vaca (Encapsulación).
    private int llet;

    // Constructor que recibe el nombre y la edad.
    public Vaca(String nom, int edat) {
        // Llamamos al constructor del padre (Animal) definiendo su tipo VACA y hábitat TERRA.
        super(nom, edat, TipusAnimal.VACA, Habitat.TERRA);
        // Inicializamos la producción de leche a 0 al crear la vaca.
        this.llet = 0;
    }

    /**
     * Método propio de la vaca (no está en la clase Animal ni en la interfaz).
     * Simula la acción de ordeñar incrementando el contador de leche.
     */
    public int munyir() {
        int punts = 10;
        llet += punts;
        return punts;
    }

    // Getter para poder consultar cuánta leche ha producido esta vaca.
    public int getLlet() { return llet; }

    // Implementación obligatoria del sonido que hace la vaca.
    public String ferSo() { return "Muuu"; }

    // --- Implementación de los métodos de la interfaz AccionsAnimals ---

    // Caminar es una acción natural para la vaca (gasto bajo: 5).
    public int caminar() { int p = 5; setVitalitat(vitalitat - p); return -p; }

    // Nadar le supone un esfuerzo considerable (gasto: 15).
    public int nadar() { int p = 15; setVitalitat(vitalitat - p); return -p; }

    // Volar es una acción imposible/crítica para una vaca (gasto máximo: 25).
    public int volar() { int p = 25; setVitalitat(vitalitat - p); return -p; }
}