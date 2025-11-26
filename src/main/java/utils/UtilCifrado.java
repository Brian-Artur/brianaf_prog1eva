package utils;

public class UtilCifrado {

    /**
     * Atributos que representan alfabeto
     */
    private static final String ALPH = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPH_MYS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int alphTam = ALPH.length();

    /**
     * Cifra una cadena con el desplazamiento dado.
     */
    public static String cifrar(String txt, int desplazamiento) {
        return trans(txt, desplazamiento);
    }

    /**
     * Descifra una cadena con el desplazamiento dado.
     */
    public static String descifrar(String txt, int desplazamiento) {
        return trans(txt, -desplazamiento);
    }

    private static String trans(String txt, int desplazamiento) {
        if (txt == null || txt.isEmpty()) return txt;       // Manejo nulos

        StringBuilder resultado = new StringBuilder();
        desplazamiento = ((desplazamiento % alphTam) + alphTam) % alphTam; // Normalizar desplazamiento
        for (char c : txt.toCharArray()) {
            if (Character.isLetter(c)) {
                String abecedario = Character.isUpperCase(c) ? ALPH_MYS : ALPH;
                int indice = abecedario.indexOf(c);
                if (indice != -1) {
                    int nuevoIndice = (indice + desplazamiento + alphTam) % alphTam;
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