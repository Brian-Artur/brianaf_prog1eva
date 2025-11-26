package utilidades;

import java.util.Scanner;

public class UtilObtencionDatos {
    private static final Scanner sc = new Scanner(System.in);

    public static int mostrarMenu(String textoMenu, int min, int max) {
        int opcion;
        do {
            System.out.print(textoMenu);
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                sc.next();
                System.out.print(textoMenu);
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            if (opcion < min || opcion > max) {
                System.out.println("Opción inválida. Debe estar entre " + min + " y " + max + ".");
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

  public static String pedirCadena(String mensaje) {
    System.out.print(mensaje);
    return sc.nextLine().trim();
  }

  public static int pedirEntero(String mensaje) {
    while (true) {
      System.out.print(mensaje);
      if (sc.hasNextInt()) {
        int valor = sc.nextInt();   // Lo lee
        sc.nextLine();              // Limpia el buffer
        return valor;               // Sale de método -> se termina el while(true)
      } else {
        System.out.println("Error: debe ser un número entero.");
        sc.next();
      }
    }
  }
}