package number;

import menu.Menu;
import utils.UtilChangNum;
import utils.UtilGetData;

public class changNum {

  public static boolean exe() {
    boolean volver = false;

    while (!volver) {
      int opcion = UtilGetData.mostrarMenu(
          Menu.menuCaNum,
          1,
          4);

      switch (opcion) {
        case 1 -> convDecBi();
        case 2 -> convBiDec();
        case 3 -> volver = true; // Volver al menú principal
        case 4 -> {
          System.out.println("Saliendo del programa...");
          return true;
        }
      }
    }
    return false;
  }

  private static void convDecBi() {
    int dec = UtilGetData.getInt("Número dec real: ");
    if (dec < 0) {
      System.out.println("Error: solo se permiten números positivos.");
      return;
    }
    String bi = UtilChangNum.decBi(dec);
    System.out.println("Resultado: " + bi + " (2)");
  }

  private static void convBiDec() {
    String bi = UtilGetData.getStr("Número bi: ");
    
    int dec = UtilChangNum.biDec(bi);
    System.out.println("Resultado: " + dec + " (10)");
  }
}
