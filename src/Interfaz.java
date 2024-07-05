import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaz {
    String nombreDivisa = "";
    String codigoDivisa = "";
    String monedaOrigen = "";
    String monedaDestino = "";
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        System.out.println("""
                Seleccione la opción deseada:
                .............................
                1- Saber Tasa de Conversión.
                2- Realizar Conversión.
                3- Obtener Código ISO de Divisa.
                4- Salir.
                .............................
                """);
    }

    public void mostrarMenuTasaConversion() throws IOException {
        int contador = 1;
        List<String> historial = new ArrayList<>();
        String nombreArchivo = "HistorialTasasConversion.txt";
        GeneradorArchivo generadorArchivo = new GeneradorArchivo();
        while (true) {
            System.out.println("""
                    Seleccione el par de divisas para obtener la tasa de conversión:
                    ..............................................................
                    1- Euro -> Dólar
                    2- Dólar -> Euro
                    3- Dólar -> Dólar Canadiense
                    4- Dólar Canadiense -> Dólar
                    5- Peso Chileno -> Dólar
                    6- Dólar -> Peso Chileno
                    7- Crear archivo con historial.
                    8- Volver al inicio.
                    """);
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    monedaOrigen = "EUR";
                    monedaDestino = "USD";
                    break;
                case 2:
                    monedaOrigen = "USD";
                    monedaDestino = "EUR";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "CAD";
                    break;
                case 4:
                    monedaOrigen = "CAD";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "CLP"; // Cambiado a Peso Chileno
                    monedaDestino = "USD";
                    break;
                case 6:
                    monedaOrigen = "USD";
                    monedaDestino = "CLP"; // Cambiado a Peso Chileno
                    break;
                case 7:
                    generadorArchivo.guardarHistorialTasasConversion(historial, nombreArchivo);
                    break;
                case 8:
                    System.out.println("Volviendo al inicio...\n");
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente...\n");
                    break;
            }
            if (opcion < 7) {
                Convertidor convertidor = new Convertidor();
                TasaConversion tasa = convertidor.obtenerTasaConversion(monedaOrigen, monedaDestino);
                String resultado = "La tasa de conversión de " + monedaOrigen + " a " + monedaDestino + " es de: " + tasa.conversion_rate();
                System.out.println("................................................................\n" +
                        resultado + "\n" +
                        "................................................................\n");
                historial.add(contador + "- " + resultado);
                contador++;
            }
        }
    }

    public void mostrarMenuConversion() throws IOException {
        int contador = 1;
        List<String> historial = new ArrayList<>();
        String nombreArchivo = "HistorialConversiones.txt";
        GeneradorArchivo generadorArchivo = new GeneradorArchivo();
        while (true) {
            System.out.println("""
                    Seleccione el par de divisas para realizar la conversión:
                    ..............................................................
                    1- Euro -> Dólar
                    2- Dólar -> Euro
                    3- Dólar -> Dólar Canadiense
                    4- Dólar Canadiense -> Dólar
                    5- Peso Chileno -> Dólar
                    6- Dólar -> Peso Chileno
                    7- Crear archivo con historial.
                    8- Volver al inicio.
                    ..............................................................
                    """);
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    monedaOrigen = "EUR";
                    monedaDestino = "USD";
                    break;
                case 2:
                    monedaOrigen = "USD";
                    monedaDestino = "EUR";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "CAD";
                    break;
                case 4:
                    monedaOrigen = "CAD";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "CLP"; // Cambiado a Peso Chileno
                    monedaDestino = "USD";
                    break;
                case 6:
                    monedaOrigen = "USD";
                    monedaDestino = "CLP"; // Cambiado a Peso Chileno
                    break;
                case 7:
                    generadorArchivo.guardarHistorialConversiones(historial, nombreArchivo);
                    break;
                case 8:
                    System.out.println("Volviendo al inicio...\n");
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente...\n");
                    break;
            }
            if (opcion < 7) {
                System.out.println("Indique la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                Convertidor convertidor = new Convertidor();
                TasaConversion tasa = convertidor.obtenerConversion(monedaOrigen, monedaDestino, cantidad);
                String resultado = "Resultado de la conversión: " + cantidad + " (" + monedaOrigen + ") equivalen a " + tasa.conversion_result() + " (" + monedaDestino + ")";
                System.out.println("...............................................................\n"
                        + resultado + "\n"
                        + "...............................................................\n");
                historial.add(contador + "- " + resultado);
                contador++;
            }
        }
    }

    public void mostrarMenuCodigosISO() throws IOException {
        int contador = 1;
        List<String> historial = new ArrayList<>();
        String nombreArchivo = "HistorialCodigosISO.txt";
        GeneradorArchivo generadorArchivo = new GeneradorArchivo();
        while (true) {
            System.out.println("""
                    Seleccione la divisa para obtener el código ISO:
                    ..............................................................
                    1- Euro.
                    2- Dólar.
                    3- Dólar Canadiense.
                    4- Peso Chileno.
                    5- Libra Esterlina.
                    6- Real Brasileño.
                    7- Crear archivo con historial.
                    8- Volver al inicio.
                    ..............................................................
                    """);
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    nombreDivisa = "Euro";
                    codigoDivisa = "EUR";
                    break;
                case 2:
                    nombreDivisa = "Dólar";
                    codigoDivisa = "USD";
                    break;
                case 3:
                    nombreDivisa = "Dólar Canadiense";
                    codigoDivisa = "CAD";
                    break;
                case 4:
                    nombreDivisa = "Peso Chileno"; // Cambiado a Peso Chileno
                    codigoDivisa = "CLP"; // Cambiado a Peso Chileno
                    break;
                case 5:
                    nombreDivisa = "Libra Esterlina";
                    codigoDivisa = "GBP";
                    break;
                case 6:
                    nombreDivisa = "Real Brasileño";
                    codigoDivisa = "BRL";
                    break;
                case 7:
                    generadorArchivo.guardarHistorialCodigosISO(historial, nombreArchivo);
                    break;
                case 8:
                    System.out.println("Volviendo al inicio...\n");
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente...\n");
                    break;
            }
            if (opcion < 7) {
                Convertidor convertidor = new Convertidor();
                TasaConversion tasa = convertidor.obtenerTasaMoneda(codigoDivisa);
                String resultado = "El código ISO de la divisa (" + nombreDivisa + ") es " + tasa.base_code();
                System.out.println("........................................................................\n"
                        + resultado + "\n"
                        + "........................................................................\n");
                historial.add(contador + "- " + resultado);
                contador++;
            }
        }
    }
}
