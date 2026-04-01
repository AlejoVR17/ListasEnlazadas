package src.main.java.co.uniquindio.estructuras.ejercicio2;

public class Nodo<T> {
    T dato;
    Nodo<T> prev;
    Nodo<T> next;

    public Nodo(T dato) {
        this.dato = dato;
        this.prev = null;
        this.next = null;
    }
}