package co.uniquindio.estructuras.ejercicio3;

class NodoCancion<T> {
    T   dato;
    NodoCancion<T> siguiente;

    NodoCancion(T dato) {
        this.dato      = dato;
        this.siguiente = null;
    }
}