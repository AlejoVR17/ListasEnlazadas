package co.uniquindio.estructuras.ejercicio3;

class PlaylistCircular {
    private NodoCancion cola;     // apunta al último nodo insertado
    private NodoCancion actual;   // nodo que se está reproduciendo ahora
    private int         tamano;

    PlaylistCircular() {
        cola   = null;
        actual = null;
        tamano = 0;
    }

    // Agregar canción al final de la lista
    void agregar(String titulo, String artista) {
        NodoCancion nueva = new NodoCancion(titulo, artista);
        if (cola == null) {
            nueva.siguiente = nueva; // apunta a sí misma (lista de 1 elemento)
            cola   = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = cola.siguiente; // nueva → primer nodo
            cola.siguiente  = nueva;          // último nodo → nueva
            cola = nueva;                     // cola avanza al nuevo nodo
        }
        tamano++;
        System.out.println("Canción agregada: \"" + titulo + "\" - " + artista);
    }

    // Eliminar una canción por título
    void eliminar(String titulo) {
        if (cola == null) {
            System.out.println("La playlist está vacía."); return;
        }
        NodoCancion cabeza  = cola.siguiente;
        NodoCancion anterior = cola;
        NodoCancion temp     = cabeza;

        do {
            if (temp.titulo.equalsIgnoreCase(titulo)) {
                if (tamano == 1) {
                    cola   = null;
                    actual = null;
                } else {
                    anterior.siguiente = temp.siguiente;
                    if (temp == cola)   cola   = anterior; // era el último
                    if (temp == actual) actual = temp.siguiente; // avanzar si era la actual
                }
                tamano--;
                System.out.println("Eliminada: \"" + titulo + "\"");
                return;
            }
            anterior = temp;
            temp     = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("Canción no encontrada: \"" + titulo + "\"");
    }

    // Avanzar a la siguiente canción (circularmente)
    void siguiente() {
        if (actual == null) {
            System.out.println("Playlist vacía."); return;
        }
        actual = actual.siguiente;
        System.out.println("Reproduciendo: \"" + actual.titulo + "\" - " + actual.artista);
    }

    // Buscar una canción por título
    void buscar(String titulo) {
        if (cola == null) { System.out.println("Playlist vacía."); return; }
        NodoCancion cabeza = cola.siguiente;
        NodoCancion temp   = cabeza;
        do {
            if (temp.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Encontrada: \"" + temp.titulo + "\" - " + temp.artista);
                return;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("Canción no encontrada: \"" + titulo + "\"");
    }

    // Mostrar todas las canciones
    void mostrar() {
        if (cola == null) { System.out.println("Playlist vacía."); return; }
        NodoCancion cabeza = cola.siguiente;
        NodoCancion temp   = cabeza;
        System.out.print("Playlist [" + tamano + "]: ");
        do {
            if (temp == actual) System.out.print("♪");
            System.out.print("[" + temp.titulo + "]");
            temp = temp.siguiente;
            if (temp != cabeza) System.out.print(" → ");
        } while (temp != cabeza);
        System.out.println(" → (vuelve al inicio)");
    }
}
