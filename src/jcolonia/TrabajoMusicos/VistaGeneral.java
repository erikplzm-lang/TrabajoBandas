package jcolonia.TrabajoMusicos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gestión de la interfaz de usuario en modo texto.
 * @author Tu Nombre
 */
public class VistaGeneral {
    private List<String> opciones;
    private static Scanner scIn = new Scanner(System.in);

    public VistaGeneral(String titulo, List<String> opciones) {
        System.out.println("\n=== " + titulo + " ===");
        this.opciones = new ArrayList<>(opciones);
    }

    public void mostrarOpciones() {
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, opciones.get(i));
        }
        System.out.println("0. Salir");
    }

    public int pedirNumero() {
        int opcion = -1;
        while (opcion < 0 || opcion > opciones.size()) {
            System.out.print("Elija opción (0-" + opciones.size() + "): ");
            if (scIn.hasNextInt()) {
                opcion = scIn.nextInt();
                scIn.nextLine(); // Limpiar el salto de línea
            } else {
                System.out.println("No es un número válido.");
                scIn.next();
            }
        }
        return opcion;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scIn.nextLine();
    }

    public static int pedirEntero(String mensaje) {
        System.out.print(mensaje + ": ");
        while (!scIn.hasNextInt()) {
            System.out.print("Error. Introduzca un número: ");
            scIn.next();
        }
        int num = scIn.nextInt();
        scIn.nextLine(); // Limpiar buffer
        return num;
    }

    public static void mostrarAviso(String texto) {
        System.out.println("\n>> " + texto);
    }
}