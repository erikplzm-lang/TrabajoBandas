package jcolonia.TrabajoMusicos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para la persistencia de datos en disco.
 * @author Tu Nombre
 */
public class AccesoArchivo {

    /**
     * Guarda una lista de cadenas en un archivo de texto.
     * @param nombreArchivo ruta del archivo
     * @param lineas lista de strings a guardar
     * @throws IOException si hay error de escritura
     */
    public void guardar(String nombreArchivo, List<String> lineas) throws IOException {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                escritor.println(linea);
            }
        }
    }

    /**
     * Lee todas las líneas de un archivo de texto.
     * @param nombreArchivo ruta del archivo
     * @return Lista de cadenas leídas
     * @throws IOException si el archivo no existe o no se puede leer
     */
    public List<String> cargar(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            throw new IOException("El archivo '" + nombreArchivo + "' no existe.");
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }
}