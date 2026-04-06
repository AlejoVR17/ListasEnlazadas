package co.uniquindio.estructuras.ejercicio3;

class PlaylistCircular<T> {
    private NodoCancion<T> cola;    // apunta al último nodo
    private NodoCancion<T> actual;  // nodo reproduciéndose ahora
    private int             tamano;

    PlaylistCircular() {
        cola   = null;
        actual = null;
        tamano = 0;
    }

    // Agregar elemento al final
    void agregar(T dato) {
        NodoCancion<T> nuevo = new NodoCancion<>(dato);
        if (cola == null) {
            nuevo.siguiente = nuevo;
            cola   = nuevo;
            actual = nuevo;
        } else {
            nuevo.siguiente = cola.siguiente; // nuevo → primer nodo
            cola.siguiente  = nuevo;          // último → nuevo
            cola = nuevo;
        }
        tamano++;
        System.out.println("Agregado: " + dato);
    }

    // Eliminar un elemento por valor
    void eliminar(T dato) {
        if (cola == null) { System.out.println("Lista vacía."); return; }

        NodoCancion<T> cabeza   = cola.siguiente;
        NodoCancion<T> anterior = cola;
        NodoCancion<T> temp     = cabeza;

        do {
            if (temp.dato.equals(dato)) {
                if (tamano == 1) {
                    cola   = null;
                    actual = null;
                } else {
                    anterior.siguiente = temp.siguiente;
                    if (temp == cola)   cola   = anterior;
                    if (temp == actual) actual = temp.siguiente;
                }
                tamano--;
                System.out.println("Eliminado: " + dato);
                return;
            }
            anterior = temp;
            temp     = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("Elemento no encontrado: " + dato);
    }

    // Avanzar a la siguiente canción (circularmente)
    void siguiente() {
        if (actual == null) { System.out.println("Lista vacía."); return; }
        actual = actual.siguiente;
        System.out.println("Reproduciendo: " + actual.dato);
    }

    // Buscar un elemento
    void buscar(T dato) {
        if (cola == null) { System.out.println("Lista vacía."); return; }
        NodoCancion<T> cabeza = cola.siguiente;
        NodoCancion<T> temp   = cabeza;
        do {
            if (temp.dato.equals(dato)) {
                System.out.println("Encontrado: " + temp.dato);
                return;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("No encontrado: " + dato);
    }

    // Mostrar toda la lista
    void mostrar() {
        if (cola == null) { System.out.println("Lista vacía."); return; }
        NodoCancion<T> cabeza = cola.siguiente;
        NodoCancion<T> temp   = cabeza;
        System.out.print("Playlist [" + tamano + "]: ");
        do {
            if (temp == actual) System.out.print("♪");
            System.out.print("[" + temp.dato + "]");
            temp = temp.siguiente;
            if (temp != cabeza) System.out.print(" → ");
        } while (temp != cabeza);
        System.out.println(" → (vuelve al inicio)");
    }
}
