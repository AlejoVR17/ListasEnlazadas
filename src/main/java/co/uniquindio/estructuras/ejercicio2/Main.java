package src.main.java.co.uniquindio.estructuras.ejercicio2;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Historial con String (URLs) ---");
        HistorialNavegacion<String> historial = new HistorialNavegacion<>();

        historial.visitar("google.com");
        historial.visitar("github.com");
        historial.visitar("stackoverflow.com");
        historial.mostrarTodo();
        // Historial: google.com <-> github.com <-> [stackoverflow.com]

        historial.retroceder();
        historial.mostrarTodo();
        // Historial: google.com <-> [github.com] <-> stackoverflow.com

        historial.avanzar();
        historial.mostrarTodo();
        // Historial: google.com <-> github.com <-> [stackoverflow.com]

        historial.retroceder();
        historial.visitar("wikipedia.org"); // corta stackoverflow.com
        historial.mostrarTodo();
        // Historial: google.com <-> github.com <-> [wikipedia.org]

        System.out.println("Buscar github.com: " + historial.buscar("github.com")); // true
        System.out.println("Buscar amazon.com: " + historial.buscar("amazon.com")); // false

        historial.mostrarActual();
        historial.eliminarActual();
        historial.mostrarTodo();
        // Historial: google.com <-> [github.com]

        System.out.println("\n---- Historial con Integer (IDs de sesión) ----");
        HistorialNavegacion<Integer> ids = new HistorialNavegacion<>();

        ids.visitar(101);
        ids.visitar(202);
        ids.visitar(303);
        ids.mostrarTodo();
        // Historial: 101 <-> 202 <-> [303]

        ids.retroceder();
        ids.mostrarTodo();
        // Historial: 101 <-> [202] <-> 303

        ids.visitar(404); // corta 303
        ids.mostrarTodo();
        // Historial: 101 <-> 202 <-> [404]
    }
}