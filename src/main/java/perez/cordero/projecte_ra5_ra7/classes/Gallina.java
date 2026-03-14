package perez.cordero.projecte_ra5_ra7.classes;

public class Gallina extends Animal {

    private int ousPosts;

    public Gallina(String nom, int edat) {
        // La gallina es de tipo GALLINA y su hábitat es el AIRE (o TERRA, según prefieras)
        // En el enunciado se menciona que "volaban al salir del agua", así que usamos AIRE.
        super(nom, edat, 40, Habitat.AIRE, TipusAnimal.GALLINA);
        this.ousPosts = 0;
    }

    // Método exclusivo: permite a la gallina poner un huevo
    public void pondreOu() {
        if (this.vitalitat > 10) {
            this.ousPosts++;
            this.reduirVitalitat(10); // Poner un huevo cansa
            System.out.println(this.nom + " ha ponut un ou! Total: " + ousPosts);
        } else {
            System.out.println(this.nom + " està massa cansada per a pondre ous.");
        }
    }

    // Implementación del movimiento (RA7)
    @Override
    public void moure() {
        System.out.println(this.nom + " fa un vol curt i bota per la granja.");
        this.reduirVitalitat(5);
    }

    // Implementación del sonido (Interfaz AccionsAnimals)
    @Override
    public void ferSo() {
        System.out.println("Xarrupa-queti-quà! (Cuaaaac!)");
    }

    // Getter para saber cuántos huevos lleva (útil para el QR o la interfaz)
    public int getOusPosts() {
        return ousPosts;
    }
}