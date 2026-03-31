package Ejercicio1;

public class Prueba {
    public static void main(String[] args) {
        System.out.println("--- Bienvenidos a la panaderia UQ ---");

        Panaderia panaderia = new Panaderia();

        panaderia.nuevoCliente();
        panaderia.nuevoCliente();
        panaderia.nuevoCliente();
        panaderia.mostrarTurnos();


        panaderia.nuevoCliente();
        panaderia.mostrarTurnos();

        panaderia.atenderCliente();
        panaderia.mostrarTurnos();
        panaderia.nuevoCliente();
        panaderia.mostrarTurnos();

    }
}
