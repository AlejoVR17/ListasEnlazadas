package Ejercicio1;

public class Panaderia {
    private Cola<String> turnos;
    private int contador;

    public Panaderia() {
        turnos = new Cola<>();
        contador = 1;
    }

    public void nuevoCliente() {
        String turno = "T" + contador++;
        turnos.insertar(turno);
        System.out.println("Turno asignado: " + turno);
    }

    public void atenderCliente() {
        if (!turnos.estaVacia()) {
            System.out.println("Atendiendo: " + turnos.eliminar());
        } else {
            System.out.println("No hay clientes");
        }
    }

    public void siguienteCliente() {
        if (!turnos.estaVacia()) {
            System.out.println("Siguiente: " + turnos.siguiente());
        } else {
            System.out.println("No hay clientes");
        }
    }

    public void mostrarTurnos() {
        System.out.print("Cola actual: ");
        turnos.mostrar();
    }
}
