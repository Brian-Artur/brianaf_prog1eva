import utils.UtilGetData;
import ahorcado.JuegoAhorcado;
import calculadora.Calculadora;
import cesar.CesarCip;
import menu.Menu;
import number.changNum;

public class Entry {
  public static void main(String[] args) {
    boolean continuar = true;

    while (continuar) {
      int opcion = UtilGetData.mostrarMenu(
       Menu.menuEntry,
        1, 5
      );

      switch (opcion) {
        case 1 -> {
          boolean salir = changNum.exe();
           if (salir) {
            continuar = false;
          }
        }
        case 2 -> {
          boolean salir = JuegoAhorcado.ejecutar();
           if (salir) {
            continuar = false;
          }
        }
        case 3 -> {
          boolean salir = Calculadora.exe();
          if (salir) {
            continuar = false;
          }
        }
        case 4 -> {
          boolean salir = CesarCip.exe();
          if (salir) {
            continuar = false;
          }
        }
        case 5 -> {
          System.out.println("¡Hasta pronto!");
          continuar = false;
        }
      }
    }
  }
}