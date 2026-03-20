package jcolonia.TrabajoMusicos;

/**
 * Representa a un integrante de una banda de rock.
 * @author Tu Nombre
 */
public class ElementoMusico {
    private String nombre;
    private String banda;
    private String instrumento;
    private int añoDebut;

    /**
     * Crea un nuevo músico con sus datos principales.
     * @param nombre nombre artístico
     * @param banda grupo al que pertenece
     * @param instrumento función en el grupo
     * @param anioDebut año de inicio profesional
     */
    public ElementoMusico(String nombre, String banda, String instrumento, int añoDebut) {
        this.nombre = nombre;
        this.banda = banda;
        this.instrumento = instrumento;
        this.añoDebut = añoDebut;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s [Debut: %d]", nombre, banda, instrumento, añoDebut);
    }

    /**
     * Convierte el objeto a formato CSV para exportación.
     * @return cadena con campos separados por punto y coma
     */
    public String toCSV() {
        return String.format("%s;%s;%s;%d", nombre, banda, instrumento, añoDebut);
    }
}