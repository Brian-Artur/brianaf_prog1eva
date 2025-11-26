package utils;

import java.util.Scanner;

public class UtilObtencionDatos {
  private static final Scanner sc = new Scanner(System.in);

  public static int mostrarMenu(String menu, int min, int max) {
    int option;
    do {
      System.out.print(menu);

      while (!sc.hasNextInt()) {
        System.out.println("Por favor, introduce un número válido.");
        sc.next();
        System.out.print(menu);
      }

      option = sc.nextInt();
      sc.nextLine(); // limpiar buffer

      if (option < min || option > max) {
        System.out.println("Opción inválida.");
      }
      
    } while (option < min || option > max);
    return option;
  }

  public static String obtenerCadena(String msg) {
    System.out.print(msg);
    return sc.nextLine().trim();
  }

  public static int obtenerEntero(String msg) {
    while (true) {
      System.out.print(msg);
      if (sc.hasNextInt()) {
        int valor = sc.nextInt(); // Lo lee
        sc.nextLine(); // Limpia el buffer
        return valor; // Sale de método -> se termina el while(true)
      } else {
        System.out.println("Error: debe ser un número entero.");
        sc.next(); // Limpia el buffer
      }
    }
  }
}