import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjerciciosIntroduccionJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== EJERCICIO 1: GESTIÓN DE RESERVAS ===");
        ejercicioReservas(sc);

        // System.out.println("\n=== EJERCICIO 2: CONTADOR DE NÚMEROS PARES ===");
        // ejercicioNumerosPares(sc);

        // System.out.println("\n=== EJERCICIO 3: CONTROL DE INVENTARIO ===");
        // ejercicioInventario(sc);

        sc.close();
    }

    /* =========================================================
       EJERCICIO 1: Gestión de reservas
       ========================================================= */

    public static void ejercicioReservas(Scanner sc) {
        int mesasDisponibles = 5;
        int reservasRealizadas = 0;
        String respuesta;


        while (true) {
            System.out.print("¿Desea asdacerrar las reservas? (S/N): ");
            respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("S")) {
                break;
            }

            System.out.print("Ingrese nombre del cliente: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese número de personas: ");
            sc.nextLine(); // el dato no afecta a la lógica, solo se solicita

            if (mesasDisponibles > 0) {
                mesasDisponibles--;
                reservasRealizadas++;
                System.out.println("Reserva confirmada para " + nombre +
                        ". Mesas disponibles: " + mesasDisponibles);
            } else {
                System.out.println("Lo sentimos, no hay mesas disponibles.");
            }
        }

        System.out.println("Reservas realizadas: " + reservasRealizadas);
        System.out.println("Fin del sistema de reservas.");
    }

    /* =========================================================
       EJERCICIO 2: Clasificación de números y conteo de pares
       ========================================================= */
    public static void ejercicioNumerosPares(Scanner sc) {
        int contadorPares = 0;
        String opcion;

        do {
            System.out.print("¿Desea ingresar un número? (S/N): ");
            opcion = sc.nextLine().toUpperCase();

            if (opcion.equals("S")) {
                System.out.print("Ingrese un número entero: ");
                int numero = Integer.parseInt(sc.nextLine());
       

                if (numero % 2 == 0) {
                    contadorPares++;
                    System.out.println("El número es par.");
                } else {
                    System.out.println("El número es impar.");
                }
            }

        } while (!opcion.equals("N"));

        System.out.println("Total de números pares: " + contadorPares);
        System.out.println("Fin del algoritmo.");
    }

    /* =========================================================
       EJERCICIO 3: Control de inventario
       ========================================================= */
    public static void ejercicioInventario(Scanner sc) {
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("ProductoA", 10);
        inventario.put("ProductoB", 5);
        inventario.put("ProductoC", 2);

        String respuesta;

        while (true) {
            System.out.print("¿Desea terminar el día? (S/N): ");
            respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("S")) {
                break;
            }

            System.out.print("¿Agregar (A) o Retirar (R) producto?: ");
            String operacion = sc.nextLine().toUpperCase();

            System.out.print("Nombre del producto: ");
            String producto = sc.nextLine();

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            if (operacion.equals("A")) {
                inventario.put(producto, inventario.getOrDefault(producto, 0) + cantidad);
                System.out.println("Producto agregado correctamente.");
            } else {
                int stockActual = inventario.getOrDefault(producto, 0);

                if (stockActual >= cantidad) {
                    inventario.put(producto, stockActual - cantidad);
                    System.out.println("Producto retirado correctamente.");
                } else {
                    System.out.println("Error: Cantidad insuficiente en inventario.");
                }
            }
        }

        System.out.println("\nInventario final:");
        for (String producto : inventario.keySet()) {
            System.out.println(producto + ": " + inventario.get(producto));
        }

        System.out.println("Fin del día.");
    }

}
