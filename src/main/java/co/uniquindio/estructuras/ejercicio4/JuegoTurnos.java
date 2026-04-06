package co.uniquindio.estructuras.ejercicio4;

class JuegoTurnos<T> {
    private NodoJugador<T> actual;
    private int                  tamano;

    JuegoTurnos() {
        actual = null;
        tamano = 0;
    }

    // Agregar jugador a la mesa
    void agregar(T dato) {
        NodoJugador<T> nuevo = new NodoJugador<>(dato);
        if (actual == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior  = nuevo;
            actual = nuevo;
        } else {
            NodoJugador<T> ultimo = actual.anterior;
            ultimo.siguiente = nuevo;
            nuevo.anterior   = ultimo;
            nuevo.siguiente  = actual;
            actual.anterior  = nuevo;
        }
        tamano++;
        System.out.println("Jugador agregado: " + dato);
    }

    // Expulsar un jugador por valor
    void eliminar(T dato) {
        if (actual == null) { System.out.println("No hay jugadores."); return; }
        NodoJugador<T> inicio = actual;
        NodoJugador<T> temp   = inicio;
        do {
            if (temp.dato.equals(dato)) {
                if (tamano == 1) {
                    actual = null;
                } else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                    if (temp == actual) actual = temp.siguiente;
                }
                tamano--;
                System.out.println("Jugador expulsado: " + dato);
                return;
            }
            temp = temp.siguiente;
        } while (temp != inicio);
        System.out.println("Jugador no encontrado: " + dato);
    }

    // Avanzar al siguiente turno
    void siguienteTurno() {
        if (actual == null) { System.out.println("No hay jugadores."); return; }
        actual = actual.siguiente;
        System.out.println("Turno de: " + actual.dato);
    }

    // Retroceder al turno anterior
    void turnoAnterior() {
        if (actual == null) { System.out.println("No hay jugadores."); return; }
        actual = actual.anterior;
        System.out.println("Turno de (retroceso): " + actual.dato);
    }

    // Buscar un jugador por valor
    void buscar(T dato) {
        if (actual == null) { System.out.println("No hay jugadores."); return; }
        NodoJugador<T> inicio = actual;
        NodoJugador<T> temp   = inicio;
        do {
            if (temp.dato.equals(dato)) {
                System.out.println("Encontrado: " + temp.dato);
                return;
            }
            temp = temp.siguiente;
        } while (temp != inicio);
        System.out.println("No encontrado: " + dato);
    }

    // Mostrar todos los jugadores en orden de turno
    void mostrar() {
        if (actual == null) { System.out.println("Sin jugadores."); return; }
        NodoJugador<T> temp = actual;
        System.out.print("Mesa [" + tamano + "]: ");
        do {
            if (temp == actual) System.out.print("★");
            System.out.print("[" + temp.dato + "]");
            temp = temp.siguiente;
            if (temp != actual) System.out.print(" ↔ ");
        } while (temp != actual);
        System.out.println(" ↻");
    }
}