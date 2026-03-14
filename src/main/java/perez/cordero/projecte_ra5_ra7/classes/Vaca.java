package perez.cordero.projecte_ra5_ra7.classes;

public class Vaca extends Animal {

    private int puntsLlet;

    public Vaca(String nom, int edat) {
        // La vaca siempre es de TERRA y tipo VACA
        super(nom, edat, 100, Habitat.TERRA, TipusAnimal.VACA);
        this.puntsLlet = 50; // Inicia con 50 puntos de leche
    }

    // Método EXCLUSIVO de la vaca [cite: 23]
    public void munyir() {
        if (puntsLlet > 0) {
            puntsLlet -= 10;
            System.out.println(nom + " ha sigut munyida. Queda " + puntsLlet + " de llet.");
        } else {
            System.out.println(nom + " no té més llet!");
        }
    }

    // Implementación obligatoria de la clase abstracta Animal
    @Override
    public void moure() {
        System.out.println(nom + " està caminant per la terra.");
        reduirVitalitat(5); // Caminar resta 5 de vitalidad [cite: 23]
    }

    // Implementación obligatoria de la interfaz AccionsAnimals
    @Override
    public void ferSo() {
        System.out.println("Muuuuu!");
    }
}