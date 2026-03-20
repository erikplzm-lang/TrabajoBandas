package jcolonia.TrabajoMusicos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Almacena y gestiona la lista de músicos.
 * @author Tu Nombre
 */
public class ConjuntoMusicos {
    private List<ElementoMusico> lista;

    public ConjuntoMusicos() {
        lista = new ArrayList<>();
    }

    public void agregar(ElementoMusico m) {
        lista.add(m);
    }

    public List<ElementoMusico> getLista() {
        return new ArrayList<>(lista);
    }

    public void exportar(String nombreArchivo) throws IOException {
        AccesoArchivo acceso = new AccesoArchivo();
        List<String> lineas = new ArrayList<>();
        
        // Convertimos cada músico a una línea CSV
        for (ElementoMusico m : lista) {
            lineas.add(m.toCSV());
        }
        
        // Usamos la clase utilitaria para guardar
        acceso.guardar(nombreArchivo, lineas);
    }

    public void importar(String nombreArchivo) throws IOException {
        AccesoArchivo acceso = new AccesoArchivo();
        List<String> lineas = acceso.cargar(nombreArchivo);
        
        // Limpiamos la lista actual antes de cargar los nuevos datos
        lista.clear(); 

        for (String linea : lineas) {
            String[] d = linea.split(";");
            if (d.length == 4) {
                try {
                    String nombre = d[0];
                    String banda = d[1];
                    String inst = d[2];
                    int anio = Integer.parseInt(d[3].trim());
                    agregar(new ElementoMusico(nombre, banda, inst, anio));
                } catch (NumberFormatException e) {
                    // Si una línea está mal, la saltamos
                    continue; 
                }
            }
        }
    }
            
}
    

