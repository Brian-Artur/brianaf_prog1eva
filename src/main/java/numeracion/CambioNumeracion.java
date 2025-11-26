package numeracion;

import utilidades.UtilObtencionDatos;
import menu.Menu;
import utilidades.UtilCambioNumeracion;

public class CambioNumeracion {

  public static boolean ejecutar() {
    boolean volver = false;

    while (!volver) {
      int opcion = UtilObtencionDatos.mostrarMenu(
          Menu.menuCaNum,
          1,
          4);

      switch (opcion) {
        case 1 -> convertirDecimalABinario();
        case 2 -> convertirBinarioADecimal();
        case 3 -> volver = true; // Volver al menú principal
        case 4 -> {
          System.out.println("Saliendo del programa...");
          return true;
        }
      }
    }
    return false;
  }

  private static void convertirDecimalABinario() {
    int decimal = UtilObtencionDatos.pedirEntero("Introduce un número decimal (entero positivo): ");
    if (decimal < 0) {
      System.out.println("Error: solo se permiten números positivos.");
      return;
    }
    String binario = UtilCambioNumeracion.decimalABinario(decimal);
    System.out.println("Resultado: " + decimal + " (10) = " + binario + " (2)");
  }

  private static void convertirBinarioADecimal() {
    String binario = UtilObtencionDatos.pedirCadena("Introduce un número binario (solo 0 y 1): ");
    try {
      int decimal = UtilCambioNumeracion.binarioADecimal(binario);
      System.out.println("Resultado: " + binario + " (2) = " + decimal + " (10)");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
