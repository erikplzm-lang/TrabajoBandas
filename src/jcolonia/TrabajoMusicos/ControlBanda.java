package jcolonia.TrabajoMusicos;

import java.util.Arrays;
import java.util.List;

/**
 * Controlador principal de la aplicación.
 * @author Tu Nombre
 */
public class ControlBanda {
    private ConjuntoMusicos conjunto;
    private VistaGeneral vista;
    private final String ARCHIVO = "datos.csv";

    public ControlBanda() {
        conjunto = new ConjuntoMusicos();
        List<String> opciones = Arrays.asList(
            "Dar de alta músico", 
            "Listar músicos", 
            "Exportar a CSV", 
            "Importar de CSV"
        );
        vista = new VistaGeneral("LISTA DE ROCKEROS", opciones);
    }

    public void buclePrincipal() {
        int op;
        do {
            vista.mostrarOpciones();
            op = vista.pedirNumero();
            try {
                switch (op) {
                    case 1 -> alta();
                    case 2 -> listar();
                    case 3 -> {
                        conjunto.exportar(ARCHIVO);
                        VistaGeneral.mostrarAviso("Datos exportados a " + ARCHIVO);
                    }
                    case 4 -> {
                        conjunto.importar(ARCHIVO);
                        VistaGeneral.mostrarAviso("Datos cargados correctamente");
                    }
                }
            } catch (Exception e) {
                VistaGeneral.mostrarAviso("Error: " + e.getMessage());
            }
        } while (op != 0);
        System.out.println("Programa finalizado.");
    }

    private void alta() {
        String nombre = vista.pedirTexto("Nombre del músico");
        String banda = vista.pedirTexto("Banda");
        String inst = vista.pedirTexto("Instrumento");
        int anio = VistaGeneral.pedirEntero("Año de debut");
        
        conjunto.agregar(new ElementoMusico(nombre, banda, inst, anio));
        VistaGeneral.mostrarAviso("Músico registrado.");
    }

    private void listar() {
        List<ElementoMusico> lista = conjunto.getLista();
        if (lista.isEmpty()) {
            VistaGeneral.mostrarAviso("La lista está vacía.");
        } else {
            System.out.println("\n--- LISTADO DE MÚSICOS ---");
            for (ElementoMusico m : lista) {
                System.out.println(m);
            }
        }
    }
}