package co.uniquindio.estructuras.ejercicio3;

public class Escenario3Musica {
    public static void main(String[] args) {
        PlaylistCircular<String> pl = new PlaylistCircular();

        pl.agregar("Bohemian Rhapsody");
        pl.agregar("Hotel California");
        pl.agregar("Stairway to Heaven");
        pl.mostrar();

        pl.siguiente(); // Hotel California
        pl.siguiente(); // Stairway to Heaven
        pl.siguiente(); // vuelve a Bohemian Rhapsody (circularidad)

        pl.eliminar("Hotel California");
        pl.mostrar();

        pl.buscar("Stairway to Heaven");
        pl.buscar("Imagine");
    }
}