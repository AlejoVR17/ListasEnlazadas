package co.uniquindio.estructuras.ejercicio4;

class NodoJugador {
    String      nombre;
    int         puntos;
    NodoJugador siguiente;
    NodoJugador anterior;

    NodoJugador(String nombre) {
        this.nombre    = nombre;
        this.puntos    = 0;
        this.siguiente = null;
        this.anterior  = null;
    }
}