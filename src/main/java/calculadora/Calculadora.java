package calculadora;

import menu.Menu;
import utils.UtilGetData;

public class Calculadora {

    public static boolean exe() {
      boolean volver = false;

      while (!volver) {
        int opcion = UtilGetData.mostrarMenu(
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
    int a = UtilGetData.obtenerEntero("Primer número: ");
    int b = UtilGetData.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

    private static void subt() {
    int a = UtilGetData.obtenerEntero("Primer número: ");
    int b = UtilGetData.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

    private static void mult() {
    int a = UtilGetData.obtenerEntero("Primer número: ");
    int b = UtilGetData.obtenerEntero("Segundo número: ");
    int res = a + b;
    System.out.println("Resultado es: " + res);
  }

  private static void divi() {
    int a = UtilGetData.obtenerEntero("Dividendo: ");
    int b = UtilGetData.obtenerEntero("Divisor: ");
    if (b == 0) {
      System.out.println("Error: no se puede dividir por cero.");
      return;
    }
    double cociente = (double) a / b;
    System.out.printf("Resultado: " + cociente);
  }

  private static void modu() {
    int a = UtilGetData.obtenerEntero("Dividendo: ");
    int b = UtilGetData.obtenerEntero("Divisor: ");
    if (b == 0) {
        System.out.println("Error: no se puede dividir por cero.");
        return;
    }
    int resto = a % b;
    System.out.println("Módulo: " + resto);
  }
}