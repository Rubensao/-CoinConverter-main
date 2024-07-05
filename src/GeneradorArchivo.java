import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorArchivo {

    // Método para guardar el historial de conversiones en un archivo de texto
    public void guardarHistorialConversiones(List<String> historial, String nombreArchivo) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            for (String entrada : historial) {
                escritor.write(entrada + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el historial de conversiones.", e);
        }
    }

    // Método para guardar el historial de tasas de conversión en un archivo de texto
    public void guardarHistorialTasasConversion(List<String> historial, String nombreArchivo) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            for (String entrada : historial) {
                escritor.write(entrada + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el historial de tasas de conversión.", e);
        }
    }

    // Método para guardar el historial de códigos ISO en un archivo de texto
    public void guardarHistorialCodigosISO(List<String> historial, String nombreArchivo) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            for (String entrada : historial) {
                escritor.write(entrada + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el historial de códigos ISO.", e);
        }
    }
}
