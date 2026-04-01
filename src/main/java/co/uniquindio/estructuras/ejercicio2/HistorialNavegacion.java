package src.main.java.co.uniquindio.estructuras.ejercicio2;

public class HistorialNavegacion<T> {
    private Nodo<T> actual;

    public HistorialNavegacion() {
        this.actual = null;
    }

    // Visitar una nueva página — elimina el futuro automáticamente
    public void visitar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (actual != null) {
            actual.next = nuevo;
            nuevo.prev  = actual;
        }
        actual = nuevo;
    }

    // Retroceder al nodo anterior
    public void retroceder() {
        if (!puedeRetroceder()) {
            System.out.println("No hay página anterior.");
            return;
        }
        actual = actual.prev;
        System.out.println("Retrocedido a: " + actual.dato);
    }

    // Avanzar al nodo siguiente
    public void avanzar() {
        if (!puedeAvanzar()) {
            System.out.println("No hay página siguiente.");
            return;
        }
        actual = actual.next;
        System.out.println("Avanzado a: " + actual.dato);
    }

    // Mostrar el nodo actual
    public void mostrarActual() {
        if (actual == null) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("Página actual: " + actual.dato);
    }

    // Mostrar todo el historial desde el primer nodo
    public void mostrarTodo() {
        if (actual == null) {
            System.out.println("Historial vacío.");
            return;
        }

        Nodo<T> temp = actual;
        while (temp.prev != null) temp = temp.prev;

        StringBuilder sb = new StringBuilder("Historial: ");
        while (temp != null) {
            if (temp == actual) sb.append("[").append(temp.dato).append("]");
            else                sb.append(temp.dato);
            if (temp.next != null) sb.append(" ↔ ");
            temp = temp.next;
        }
        System.out.println(sb);
    }

    // Buscar si un dato existe en el historial
    public boolean buscar(T dato) {
        Nodo<T> temp = actual;
        while (temp != null && temp.prev != null) temp = temp.prev;

        while (temp != null) {
            if (temp.dato.equals(dato)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Eliminar el nodo actual y reajustar punteros
    public void eliminarActual() {
        if (actual == null) {
            System.out.println("Historial vacío.");
            return;
        }

        T eliminado = actual.dato;

        if (actual.prev != null) {
            actual.prev.next = actual.next;
            if (actual.next != null) actual.next.prev = actual.prev;
            actual = actual.prev;
        } else if (actual.next != null) {
            actual.next.prev = null;
            actual = actual.next;
        } else {
            actual = null;
        }

        System.out.println("Eliminado: " + eliminado);
    }

    private boolean puedeRetroceder() {
        return actual != null && actual.prev != null;
    }

    private boolean puedeAvanzar() {
        return actual != null && actual.next != null;
    }
}