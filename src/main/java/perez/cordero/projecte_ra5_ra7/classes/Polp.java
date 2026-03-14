package perez.cordero.projecte_ra5_ra7.classes;

public class Polp extends Animal {

    private int quantitatTinta;

    public Polp(String nom, int edat) {
        // El pulpo es tipo POLP y vive en el AIGUA
        super(nom, edat, 80, Habitat.AIGUA, TipusAnimal.POLP);
        this.quantitatTinta = 100; // Inicia con el depósito de tinta lleno
    }

    // Método exclusivo del Pulpo (no presente en vacas ni gallinas)
    public void amollarTinta() {
        if (quantitatTinta >= 20) {
            quantitatTinta -= 20;
            System.out.println(this.nom + " ha soltado una nube de tinta para escapar!");
        } else {
            System.out.println(this.nom + " no tiene suficiente tinta.");
        }
    }

    @Override
    public void moure() {
        System.out.println(this.nom + " se impulsa con sus tentáculos por el fondo marino.");
        this.reduirVitalitat(10); // Mover los tentáculos cansa más
    }

    @Override
    public void ferSo() {
        // Los pulpos no hacen mucho ruido, representamos el sonido del agua
        System.out.println("*Sonido de burbujas y succión*");
    }
}