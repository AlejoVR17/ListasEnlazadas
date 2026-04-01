package co.uniquindio.estructuras.ejercicio3;

public class Escenario3Musica {
    public static void main(String[] args) {
        PlaylistCircular pl = new PlaylistCircular();

        pl.agregar("Bohemian Rhapsody", "Queen");
        pl.agregar("Hotel California",  "Eagles");
        pl.agregar("Stairway to Heaven","Led Zeppelin");
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