package ahorcado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import principal.MenuPrincipal;
import utils.UtilObtencionDatos;

public class JuegoAhorcado {

    //^ ====================== CONFIGURACIÓN POR DEFECTO ======================
    private static final int INTENTOS_POR_DEFECTO = 6;
    private static final String[] PALABRAS_POR_DEFECTO = {
        "java", "programacion", "ordenador", "teclado", "raton",
        "monitor", "clase", "objeto", "metodo", "variable"
    };

    private static int maximoIntentos = INTENTOS_POR_DEFECTO;
    private static List<String> palabrasDisponibles = new ArrayList<>(List.of(PALABRAS_POR_DEFECTO));

    //? ====================== MENÚ PRINCIPAL ======================
    public static boolean ejecutar() {
        boolean salir = false;

        while (!salir) {
            int opcion = UtilObtencionDatos.mostrarMenu(
                MenuPrincipal.menuAhoracado.formatted(maximoIntentos, palabrasDisponibles.size()), 1, 5);

            switch (opcion) {
                case 1 -> configurarIntentos();
                case 2 -> configurarPalabras();
                case 3 -> jugar();
                case 4 -> salir = true;
                case 5 -> { System.out.println("Saliendo del programa..."); return true; }
            }
        }
        return false;
    }

    //^ ====================== CONFIGURACIÓN ======================
    private static void configurarIntentos() {
        int nuevo = UtilObtencionDatos.obtenerEntero(
            "Introduce el número de intentos (mínimo 1, actual: " + maximoIntentos + "): ");
        if (nuevo < 1) {
            System.out.println("Error: debe haber al menos 1 intento.");
        } else {
            maximoIntentos = nuevo;
            System.out.println("Intentos actualizados a: " + maximoIntentos);
        }
    }

    private static void configurarPalabras() {
        int cantidad = UtilObtencionDatos.obtenerEntero("¿Cuántas palabras quieres introducir? (0 para cancelar): ");

        if (cantidad <= 0) {
            System.out.println("Se mantienen las palabras actuales.");
            return;
        }

        List<String> nuevasPalabras = new ArrayList<>();
        System.out.println("Introduce las " + cantidad + " palabras (solo letras minúsculas, sin acentos):");

        for (int i = 0; i < cantidad; i++) {
            String palabra = UtilObtencionDatos.obtenerCadena("Palabra " + (i + 1) + ": ").trim().toLowerCase();
            if (palabra.matches("[a-z]+")) {
                nuevasPalabras.add(palabra);
            } else {
                System.out.println("Palabra inválida (solo letras). Se omite.");
                i--; // Repetir esta posición
            }
        }

        if (!nuevasPalabras.isEmpty()) {
            palabrasDisponibles = nuevasPalabras;
            System.out.println("Palabras actualizadas. Total: " + palabrasDisponibles.size());
        } else {
            System.out.println("No se añadió ninguna palabra válida. Se mantienen las anteriores.");
        }
    }

    //^ ====================== JUEGO PRINCIPAL ======================
    private static void jugar() {
        if (palabrasDisponibles.isEmpty()) {
            System.out.println("Error: no hay palabras disponibles. Configura al menos una.");
            return;
        }

        String palabraSecreta = seleccionarPalabraAleatoria();
        char[] progreso = inicializarProgreso(palabraSecreta);
        int intentosRestantes = maximoIntentos;
        Set<Character> letrasUsadas = new HashSet<>();

        System.out.println("\n¡Comienza el juego! Palabra de " + palabraSecreta.length() + " letras.\n");

        while (intentosRestantes > 0 && contieneGuiones(progreso)) {
            mostrarEstado(progreso, intentosRestantes, letrasUsadas);

            String entrada = UtilObtencionDatos.obtenerCadena("Introduce una letra o intenta adivinar la palabra completa: ")
                                      .trim().toLowerCase();

            if (esIntentoLetraValida(entrada, letrasUsadas)) {
                char letra = entrada.charAt(0);
                letrasUsadas.add(letra);

                if (palabraSecreta.indexOf(letra) == -1) {
                    intentosRestantes--;
                    System.out.println("Incorrecto. '" + letra + "' no está. Te quedan " + intentosRestantes + " intento" + (intentosRestantes == 1 ? "" : "s") + ".");
                } else {
                    actualizarProgreso(palabraSecreta, progreso, letra);
                    System.out.println("¡Acertaste! La letra '" + letra + "' sí está.");
                }
            }
            else if (entrada.equals(palabraSecreta)) {
                revelarPalabraCompleta(progreso, palabraSecreta);
                break;
            }
            else {
                intentosRestantes--;
                System.out.println("Palabra incorrecta. Te quedan " + intentosRestantes + " intento" + (intentosRestantes == 1 ? "" : "s") + ".");
            }
        }

        mostrarResultadoFinal(progreso, palabraSecreta, intentosRestantes > 0 || !contieneGuiones(progreso));
    }

    //^ ====================== MÉTODOS AUXILIARES DEL JUEGO ======================

    private static String seleccionarPalabraAleatoria() {
        int indice = (int) (Math.random() * palabrasDisponibles.size());
        return palabrasDisponibles.get(indice);
    }

    private static char[] inicializarProgreso(String palabra) {
        char[] progreso = new char[palabra.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
        return progreso;
    }

    private static boolean contieneGuiones(char[] progreso) {
        for (char c : progreso) {
            if (c == '_') return true;
        }
        return false;
    }

    private static void actualizarProgreso(String palabra, char[] progreso, char letra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;
            }
        }
    }

    private static void revelarPalabraCompleta(char[] progreso, String palabra) {
        char[] caracteres = palabra.toCharArray();
        System.arraycopy(caracteres, 0, progreso, 0, caracteres.length);
    }

    private static boolean esIntentoLetraValida(String entrada, Set<Character> usadas) {
        return entrada.length() == 1 
            && Character.isLetter(entrada.charAt(0)) 
            && !usadas.contains(entrada.charAt(0));
    }

    private static void mostrarEstado(char[] progreso, int intentos, Set<Character> usadas) {
        System.out.print("Palabra: ");
        for (char c : progreso) System.out.print(c + " ");
        System.out.println("\nIntentos restantes: " + intentos);

        if (!usadas.isEmpty()) {
            System.out.print("Letras usadas: ");
            usadas.stream()
                  .sorted()
                  .forEach(letra -> System.out.print(letra + " "));
            System.out.println();
        }
        System.out.println();
    }

    private static void mostrarResultadoFinal(char[] progreso, String palabra, boolean ganado) {
        System.out.println("=====================================");
        mostrarEstado(progreso, 0, Set.of());
        
        if (ganado) {
            System.out.println("¡FELICIDADES! Has ganado!");
        } else {
            System.out.println("¡GAME OVER! Se acabaron los intentos.");
        }
        System.out.println("La palabra era: " + palabra);
        System.out.println("=====================================\n");
    }
}