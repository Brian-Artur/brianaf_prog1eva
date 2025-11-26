package cesar;

import menu.Menu;
import utils.UtilCifrado;
import utils.UtilObtencionDatos;

public class CifradoCesar {

  private static int desplazamiento = 1; // Valor por defecto

  public static boolean exe() {
    boolean back = false;

    while (!back) {
      int option = UtilObtencionDatos.mostrarMenu(
          Menu.menuCesar.formatted(desplazamiento),
          1,
          5);

      switch (option) {
        case 1 -> indicarDesplazamiento();
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

  private static void indicarDesplazamiento() {
    int ch = UtilObtencionDatos.obtenerEntero(
        "Valor del desplazamiento actual es" + desplazamiento + "\nIntroduce un valor (1-25) : ");
        
    if (ch < 1 || ch > UtilCifrado.ALPH.length()) {
      System.out.println("Error: el desplazamiento debe estar entre 1 y 25.");
    } else {
      desplazamiento = ch;
      System.out.println("Desplazamiento actualizado a: " + desplazamiento);
    }
  }

  private static void cifrar() {

    String txt = UtilObtencionDatos.obtenerCadena("Introduce el txt a cifrar: ");

    String cifrado = UtilCifrado.cifrar(txt, desplazamiento);
    System.out.println("txt cifrado: " + cifrado);
  }

  private static void descifrar() {

    String txt = UtilObtencionDatos.obtenerCadena("Introduce el txt a descifrar: ");

    String descifrado = UtilCifrado.descifrar(txt, desplazamiento);
    System.out.println("txt descifrado: " + descifrado);
  }
}