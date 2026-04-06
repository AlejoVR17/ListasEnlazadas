package co.uniquindio.estructuras.ejercicio4;

public class Escenario4Juego {
    public static void main(String[] args) {
        JuegoTurnos juego = new JuegoTurnos();

        juego.agregar("Sofía");
        juego.agregar("Carlos");
        juego.agregar("Elena");
        juego.agregar("Marcos");
        juego.mostrar();


        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.turnoAnterior();

        juego.eliminar("Elena");
        juego.mostrar();

        juego.buscar("Carlos");
        juego.buscar("Elena");
    }
}