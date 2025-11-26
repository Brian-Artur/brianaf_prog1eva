package cesar;

import menu.Menu;
import utils.UtilEncry;
import utils.UtilGetData;

public class CesarCip {

  private static int move = 1; // Valor por defecto

  public static boolean exe() {
    boolean back = false;

    while (!back) {
      int option = UtilGetData.mostrarMenu(
          Menu.menuCesar.formatted(move),
          1,
          5);

      switch (option) {
        case 1 -> configDesp();
        case 2 -> cifrar();
        case 3 -> descifrar();
        case 4 -> back = true;
        case 5 -> {
          System.out.println("Saliendo del programa...");
          return true;
        }
      }
    }
    return false;
  }

  private static void configDesp() {
    int ch = UtilGetData.obtenerEntero(
        "Introduce el desplazamiento (1-25, actual: " + move + "): ");
    if (ch < 1 || ch > 25) {
      System.out.println("Error: el desplazamiento debe estar entre 1 y 25.");
    } else {
      move = ch;
      System.out.println("Desplazamiento actualizado a: " + move);
    }
  }

  private static void cifrar() {
    String txt = UtilGetData.obtenerCadena("Introduce el txt a cifrar: ");
    String cifrado = UtilEncry.cifrar(txt, move);
    System.out.println("txt cifrado: " + cifrado);
  }

  private static void descifrar() {
    String txt = UtilGetData.obtenerCadena("Introduce el txt a descifrar: ");
    String descifrado = UtilEncry.descifrar(txt, move);
    System.out.println("txt descifrado: " + descifrado);
  }
}