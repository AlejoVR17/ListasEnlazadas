package co.uniquindio.estructuras.ejercicio4;

public class Escenario4Juego {
    public static void main(String[] args) {
        JuegoTurnos juego = new JuegoTurnos();

        juego.agregar("Sofía");
        juego.agregar("Carlos");
        juego.agregar("Elena");
        juego.agregar("Marcos");
        juego.mostrar();

        juego.consultarVecinos();

        juego.siguienteTurno(); // Carlos
        juego.siguienteTurno(); // Elena
        juego.siguienteTurno(); // Marcos
        juego.siguienteTurno(); // Sofía (circular: regresa al inicio)
        juego.mostrar();

        juego.eliminar("Elena");
        juego.mostrar();

        juego.buscar("Marcos");
        juego.consultarVecinos();
    }
}