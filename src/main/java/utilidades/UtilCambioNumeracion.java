package utilidades;

public class UtilCambioNumeracion {

  /**
   * Convierte un número decimal a binario usando divisiones sucesivas.
   */
  public static String decimalABinario(int decimal) {
    if (decimal == 0)
      return "0";
    if (decimal < 0)
      return "Número negativo no soportado";

    StringBuilder binario = new StringBuilder();
    while (decimal > 0) {
      binario.insert(0, decimal % 2);
      decimal /= 2;
    }
    return binario.toString();
  }

  /**
   * Convierte un número binario (como String) a decimal usando el teorema
   * fundamental.
   */
  public static int binarioADecimal(String binario) {
    binario = binario.trim();
    if (!binario.matches("[01]+")) {
      throw new IllegalArgumentException("Cadena binaria inválida");
    }

    int decimal = 0;
    int potencia = 0;
    // Recorremos de derecha a izquierda
    for (int i = binario.length() - 1; i >= 0; i--) {
      if (binario.charAt(i) == '1') {
        decimal += Math.pow(2, potencia);
      }
      potencia++;
    }
    return decimal;
  }
}
