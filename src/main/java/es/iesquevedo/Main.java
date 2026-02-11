package es.iesquevedo;

import es.iesquevedo.app.ConsoleApp;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Crear contenedor Weld
        Weld weld = new Weld();

        try (WeldContainer container = weld.initialize()) {

            // Obtener la instancia de ConsoleApp a través de CDI
            ConsoleApp app = container.select(ConsoleApp.class).get();

            Scanner scanner = new Scanner(System.in);

            boolean salir = false;
            while (!salir) {
                System.out.println("\nOpciones:");
                System.out.println("1 - Crear socio");
                System.out.println("2 - Listar socios");
                System.out.println("3 - Eliminar socio");
                System.out.println("0 - Salir");
                System.out.print("Opción: ");
                String opcion = scanner.nextLine().trim();

                switch (opcion) {
                    case "1" -> app.crearSocio(scanner);
                    case "2" -> app.listarSocios();
                    case "3" -> app.eliminarSocio(scanner);
                    case "0" -> salir = true;
                    default -> System.out.println("Opción no válida");
                }
            }
        }
    }
}
