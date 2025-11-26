package calculadora;

import menu.Menu;
import utils.UtilObtencionDatos;

public class Calculadora {

    public static boolean exe() {
      boolean volver = false;

      while (!volver) {
        int opcion = UtilObtencionDatos.mostrarMenu(
            Menu.menuCalculadora,
            1, 
            7
        );

        switch (opcion) {
          case 1 -> sum();
          case 2 -> subt();
          case 3 -> mult();
          case 4 -> divi();
          case 5 -> modu();
          case 6 -> volver = true;
          case 7 -> {
            System.out.println("Saliendo del programa...");
            return true;
          }
        }
      }
      return false;
    }

  private static void sum() {
    int a = UtilObtencionDatos.obtenerEntero("Primer número: ");
    int b = UtilObtencionDatos.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

    private static void subt() {
    int a = UtilObtencionDatos.obtenerEntero("Primer número: ");
    int b = UtilObtencionDatos.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

    private static void mult() {
    int a = UtilObtencionDatos.obtenerEntero("Primer número: ");
    int b = UtilObtencionDatos.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

  private static void divi() {
    int a = UtilObtencionDatos.obtenerEntero("Dividendo: ");
    int b = UtilObtencionDatos.obtenerEntero("Divisor: ");
    if (b == 0) {
      System.out.println("Error: no se puede dividir por cero.");
      return;
    }
    double cociente = (double) a / b;
    System.out.printf("Resultado: " + cociente);
  }

  private static void modu() {
    int a = UtilObtencionDatos.obtenerEntero("Dividendo: ");
    int b = UtilObtencionDatos.obtenerEntero("Divisor: ");
    if (b == 0) {
        System.out.println("Error: no se puede dividir por cero.");
        return;
    }
    int resto = a % b;
    System.out.println("Módulo: " + resto);
  }
}