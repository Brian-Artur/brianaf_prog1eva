package utilidades;

public class UtilCifrado {

    private static final String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz";
    private static final String ABECEDARIO_MAYUS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Cifra una cadena con el desplazamiento dado.
     */
    public static String cifrar(String texto, int desplazamiento) {
        return transformar(texto, desplazamiento);
    }

    /**
     * Descifra una cadena con el desplazamiento dado.
     */
    public static String descifrar(String texto, int desplazamiento) {
        return transformar(texto, -desplazamiento);
    }

    private static String transformar(String texto, int desplazamiento) {
        if (texto == null || texto.isEmpty()) return texto;

        StringBuilder resultado = new StringBuilder();
        desplazamiento = ((desplazamiento % 26) + 26) % 26; // Normalizar: positivo y módulo 26

        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                String abecedario = Character.isUpperCase(c) ? ABECEDARIO_MAYUS : ABECEDARIO;
                int indice = abecedario.indexOf(c);
                if (indice != -1) {
                    int nuevoIndice = (indice + desplazamiento + 26) % 26;
                    resultado.append(abecedario.charAt(nuevoIndice));
                } else {
                    resultado.append(c); // En teoría no llega aquí
                }
            } else {
                resultado.append(c); // Espacios, números, símbolos → sin cambio
            }
        }
        return resultado.toString();
    }
}