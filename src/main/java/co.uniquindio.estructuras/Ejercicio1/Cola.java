package co.uniquindio.estructuras.Ejercicio1;

public class Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int size;

    public Cola() {
        frente = null;
        fin = null;
        size = 0;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        size++;
    }

    public T eliminar() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }

        T dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        size--;
        return dato;
    }

    public T siguiente() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int size() {
        return size;
    }

    public void mostrar() {
        Nodo<T> actual = frente;

        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }

        System.out.println("FIN");
    }
}
