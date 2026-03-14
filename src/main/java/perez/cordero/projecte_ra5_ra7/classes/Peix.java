package perez.cordero.projecte_ra5_ra7.classes;

public class Peix extends Animal {

    public Peix(String nom, int edat) {
        super(nom, edat, 50, Habitat.AIGUA, TipusAnimal.PEIX);
    }

    // El pez no tiene el método munyir(), así solucionamos el bug de MinecraftDam1.
    // Solo tiene métodos propios de nadar.

    @Override
    public void moure() {
        System.out.println(nom + " està nadant ràpidament.");
        reduirVitalitat(2); // Nadar gasta menos energía que caminar [cite: 23]
    }

    @Override
    public void ferSo() {
        System.out.println("Glu glu glu...");
    }
}