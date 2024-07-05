import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                ........................................
                ***** BIENVENIDO A CONVERTIDOR DE DIVISAS *****
                ........................................
                """);
        while (true) {
            Interfaz interfaz = new Interfaz();
            interfaz.mostrarMenuPrincipal();
            try {
                int opcionMenu = scanner.nextInt();

                switch (opcionMenu) {
                    case 1:
                        interfaz.mostrarMenuTasaConversion();
                        break;
                    case 2:
                        interfaz.mostrarMenuConversion();
                        break;
                    case 3:
                        interfaz.mostrarMenuCodigosISO();
                        break;
                    case 4:
                        System.out.println("Gracias por utilizar nuestro servicio, ¡que tenga un excelente día!");
                        return;
                    default:
                        System.out.println("Opción no encontrada, intente nuevamente...\n");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Divisa no encontrada.");
                System.out.println("Finalizando aplicación.");
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
