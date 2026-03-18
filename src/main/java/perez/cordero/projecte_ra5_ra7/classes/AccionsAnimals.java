package perez.cordero.projecte_ra5_ra7.classes;

// Una interfaz en Java es un "contrato" que define qué métodos deben implementar las clases que la usen.
// Obliga a que todos los animales tengan estos comportamientos,
// pero cada uno los implementará a su manera (Polimorfismo).
public interface AccionsAnimals {

    // Método que devuelve un entero; representará la lógica de caminar de un animal.
    int caminar();

    // Método para definir cómo nada el animal; la implementación dependerá de la clase concreta.
    int nadar();

    // Método para definir el vuelo; si un animal no vuela, la clase que implemente esta interfaz decidirá qué retornar.
    int volar();
}