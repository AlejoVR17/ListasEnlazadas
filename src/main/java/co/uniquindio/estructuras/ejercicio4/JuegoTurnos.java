package co.uniquindio.estructuras.ejercicio4;

class JuegoTurnos {
    private NodoJugador turnoActual; // jugador cuyo turno es ahora
    private int         numJugadores;

    JuegoTurnos() {
        turnoActual   = null;
        numJugadores  = 0;
    }

    // Agregar un nuevo jugador a la mesa
    void agregar(String nombre) {
        NodoJugador nuevo = new NodoJugador(nombre);
        if (turnoActual == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior  = nuevo;
            turnoActual     = nuevo;
        } else {
            // Insertar antes del turno actual (al "final" de la lista circular)
            NodoJugador ultimo = turnoActual.anterior;
            ultimo.siguiente  = nuevo;
            nuevo.anterior    = ultimo;
            nuevo.siguiente   = turnoActual;
            turnoActual.anterior = nuevo;
        }
        numJugadores++;
        System.out.println("Jugador agregado: " + nombre);
    }

    // Expulsar a un jugador de la partida
    void eliminar(String nombre) {
        if (turnoActual == null) {
            System.out.println("No hay jugadores."); return;
        }
        NodoJugador inicio = turnoActual;
        NodoJugador temp   = inicio;
        do {
            if (temp.nombre.equalsIgnoreCase(nombre)) {
                if (numJugadores == 1) {
                    turnoActual = null;
                } else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                    if (temp == turnoActual) turnoActual = temp.siguiente;
                }
                numJugadores--;
                System.out.println("Jugador expulsado: " + nombre);
                return;
            }
            temp = temp.siguiente;
        } while (temp != inicio);
        System.out.println("Jugador no encontrado: " + nombre);
    }

    // Pasar el turno al siguiente jugador
    void siguienteTurno() {
        if (turnoActual == null) { System.out.println("No hay jugadores."); return; }
        turnoActual = turnoActual.siguiente;
        System.out.println("Turno de: " + turnoActual.nombre);
    }

    // Pasar el turno al jugador anterior (si el juego lo permite)
    void turnoAnterior() {
        if (turnoActual == null) { System.out.println("No hay jugadores."); return; }
        turnoActual = turnoActual.anterior;
        System.out.println("Turno de (retroceso): " + turnoActual.nombre);
    }

    // Consultar quién juega antes y después del turno actual
    void consultarVecinos() {
        if (turnoActual == null) { System.out.println("No hay jugadores."); return; }
        System.out.println("Jugó antes : " + turnoActual.anterior.nombre);
        System.out.println("Juega ahora: " + turnoActual.nombre);
        System.out.println("Juega luego: " + turnoActual.siguiente.nombre);
    }

    // Buscar un jugador por nombre
    void buscar(String nombre) {
        if (turnoActual == null) { System.out.println("No hay jugadores."); return; }
        NodoJugador inicio = turnoActual;
        NodoJugador temp   = inicio;
        do {
            if (temp.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + temp.nombre + " | puntos: " + temp.puntos);
                return;
            }
            temp = temp.siguiente;
        } while (temp != inicio);
        System.out.println("Jugador no encontrado: " + nombre);
    }

    // Mostrar todos los jugadores en orden de turno
    void mostrar() {
        if (turnoActual == null) { System.out.println("Sin jugadores."); return; }
        NodoJugador temp = turnoActual;
        System.out.print("Mesa (" + numJugadores + " jugadores): ");
        do {
            if (temp == turnoActual) System.out.print("★");
            System.out.print("[" + temp.nombre + "]");
            temp = temp.siguiente;
            if (temp != turnoActual) System.out.print(" ↔ ");
        } while (temp != turnoActual);
        System.out.println(" ↻ (circular)");
    }
}