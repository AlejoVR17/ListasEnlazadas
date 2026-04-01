package co.uniquindio.estructuras.ejercicio3;

class NodoCancion {
    String    titulo;
    String    artista;
    NodoCancion siguiente;

    NodoCancion(String titulo, String artista) {
        this.titulo   = titulo;
        this.artista  = artista;
        this.siguiente = null;
    }
}