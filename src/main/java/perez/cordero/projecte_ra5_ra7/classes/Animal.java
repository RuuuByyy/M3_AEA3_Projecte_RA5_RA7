package perez.cordero.projecte_ra5_ra7.classes;

// Importamos la interfaz Serializable para que los objetos de esta clase
// puedan ser convertidos en un flujo de bytes (útil para guardar en archivos).
import java.io.Serializable;

// La palabra 'abstract' indica que no podemos crear un objeto "Animal" genérico.
// Sirve como molde base para que otras clases (como Gos, Gat, etc.) hereden de ella.
public abstract class Animal implements Serializable {

    // Usamos 'protected' para que las clases que hereden de esta puedan
    // acceder directamente a estos atributos sin necesidad de getters/setters internos.
    protected String nom;
    protected int edat;
    protected TipusAnimal tipus;
    protected Habitat habitat;
    protected int vitalitat;

    // Constructor de la clase base. Se ejecutará cuando una clase hija use 'super()'.
    public Animal(String nom, int edat, TipusAnimal tipus, Habitat habitat) {
        this.nom = nom;
        this.edat = edat;
        this.tipus = tipus;
        this.habitat = habitat;
        this.vitalitat = 100; // Por defecto, el animal empieza con la vitalidad al máximo.
    }

    // Métodos Getter: permiten consultar los atributos desde fuera de la clase.
    public String getNom() { return nom; }
    public TipusAnimal getTipus() { return tipus; }
    public Habitat getHabitat() { return habitat; }
    public int getEdat() { return edat; }
    public int getVitalitat() { return vitalitat; }

    // Método Setter con lógica de control.
    // Math.max y Math.min aseguran que el valor siempre esté en el rango [0, 100].
    public void setVitalitat(int vitalitat) {
        this.vitalitat = Math.max(0, Math.min(100, vitalitat));
    }

    // Método que define una acción común. Aumenta la vitalidad en 20 unidades.
    public int descansar() {
        int recuperat = 20;
        setVitalitat(vitalitat + recuperat);
        return recuperat;
    }

    // Método abstracto: no tiene cuerpo aquí.
    // Obliga a todas las clases hijas a definir su propio sonido (polimorfismo).
    public abstract String ferSo();

    // Sobrescritura del método toString para personalizar cómo se imprime el objeto en consola o UI.
    @Override
    public String toString() {
        return nom + " - " + tipus + " - " + edat + " anys - Vitalitat: " + vitalitat;
    }
}