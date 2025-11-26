package utils;

public class UtilCifrado {

  /**
   * Atributos que representan alfabeto
   */
  public static final String ALPH = "abcdefghijklmnopqrstuvwxyz";
  public static final String ALPH_MYS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static int alfabetoTam = ALPH.length();

  /**
   * Cifra una cadena con el desplazamiento dado.
   */
  public static String cifrar(String txt, int desplazamiento) {
    return transformar(txt, desplazamiento);
  }

  /**
   * Descifra una cadena con el desplazamiento dado.
   */
  public static String descifrar(String txt, int desplazamiento) {
    return transformar(txt, -desplazamiento);
  }

  private static String transformar(String txt, int desplazamiento) {
    if (txt == null || txt.isEmpty())
      return txt;

    StringBuilder resultado = new StringBuilder();
    // Paso de string a array de caracteres
    for (char c : txt.toCharArray()) {
      if (Character.isLetter(c)) {
        String alfabeto = Character.isUpperCase(c) ? ALPH_MYS : ALPH;   // Determinar alph correcto
        int posicion = alfabeto.indexOf(c);   // Encontrar posición actual
        // Nueva posición necesita "dar la vuelta" al alph
        int nuevaPosicion = (posicion + desplazamiento) % alfabetoTam;
        // añadir letra cifrada
        resultado.append(alfabeto.charAt(nuevaPosicion));
      } else {
        resultado.append(c);  // Si no es una letra
      }
    }
    // char[] => StringBuilder => String
    return resultado.toString();
  }
}