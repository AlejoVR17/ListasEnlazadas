package co.uniquindio.estructuras.ejercicio4;

class NodoJugador<T> {
    T                    dato;
    NodoJugador<T> siguiente;
    NodoJugador<T> anterior;

    NodoJugador(T dato) {
        this.dato      = dato;
        this.siguiente = null;
        this.anterior  = null;
    }
}