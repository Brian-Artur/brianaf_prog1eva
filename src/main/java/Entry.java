import utils.UtilObtencionDatos;
import ahorcado.JuegoAhorcado;
import calculadora.Calculadora;
import cesar.CifradoCesar;
import menu.Menu;
import numeracion.CambioNumeracion;

public class Entry {
  public static void main(String[] args) {
    boolean continuar = true;

    while (continuar) {
      int opcion = UtilObtencionDatos.mostrarMenu(
       Menu.menuPrincipal,
        1, 5
      );

      switch (opcion) {
        case 1 -> {
          boolean salir = CambioNumeracion.ejecutar();
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
          boolean salir = CifradoCesar.exe();
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