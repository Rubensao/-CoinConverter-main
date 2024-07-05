import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Convertidor {

    // Método para convertir una cantidad de una divisa a otra
    public TasaConversion obtenerConversion(String monedaOrigen, String monedaDestino, double cantidad){
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/a0698440d31c85f6ea27e28c/pair/" + monedaOrigen +"/"+ monedaDestino + "/" + cantidad);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> respuesta;
            respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), TasaConversion.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para obtener la tasa de conversión entre dos divisas
    public TasaConversion obtenerTasaConversion(String monedaOrigen, String monedaDestino){
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/a0698440d31c85f6ea27e28c/pair/" + monedaOrigen +"/"+ monedaDestino + "/");
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> respuesta;
            respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), TasaConversion.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para obtener las tasas de conversión para una divisa específica
    public TasaConversion obtenerTasaMoneda(String divisa){
        URI uri = URI.create("https://open.er-api.com/v6/latest/" + divisa);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> respuesta;
            respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), TasaConversion.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Divisa no encontrada.");
        }
    }
}
