import javax.swing.*;
import java.util.Arrays;

public class CalculadoraFraccionesEnJOptionPane {

    private static final Object[] MENU = Arrays.asList("Fracciones", "Fracciones Mixtas", "Convertir fracciones", "Salir").toArray();
    private static final int FRACCIONES = 0;
    private static final int FRACCIONESMIXAS = 1;
    private static final int CONVERTIR = 2;
    private static final int SALIR = 3;

    private static final Object[] OPCIONES = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir").toArray();
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;

    private static final Object[] CONVERTIR_OPCIONES = Arrays.asList("Convertir fracciones", "Convertir fracciones Mixtas").toArray();
    private static final int CONVERTIR_FRACCIONES = 0;
    private static final int CONVERTIR_FRACCIONES_MIXTAS = 1;

    public static void main(String[] args) throws Exception {
        while (true) {

            int tipoElegida = mostrarMenuPrincipal();
            switch (tipoElegida) {
                case FRACCIONES:
                    int opcionElegidaFr = mostrarMenuOpciones();
                    Fraccion fraccionUno = crearFraccion();
                    Fraccion fraccionDos = crearFraccion();
                    realizarOperacionFracciones(opcionElegidaFr, fraccionUno, fraccionDos);
                    break;

                case FRACCIONESMIXAS:
                    int opcionElegidaMx = mostrarMenuOpciones();
                    FraccionMixta fraccionMixtaUno = crearFraccionMixta();
                    FraccionMixta fraccionMixtaDos = crearFraccionMixta();
                    realizarOperacionFraccionesMixtas(opcionElegidaMx, fraccionMixtaUno, fraccionMixtaDos);
                    break;

                case CONVERTIR:
                    int opcionElegidaCv = mostrarMenuConvertir();
                    realizarOperacionConvertir(opcionElegidaCv);
                    break;

                case SALIR:
                    System.exit(0);
            }
        }
    }

    private static void realizarOperacionFracciones(int opcion, Fraccion fraccionUno, Fraccion fraccionDos) throws Exception {
        switch (opcion) {
            case SUMAR:
                mostrarMensaje("La suma es " + Calculadora.sumar(fraccionUno, fraccionDos));
                break;
            case RESTAR:
                mostrarMensaje("La resta es " + Calculadora.restar(fraccionUno, fraccionDos));
                break;
            case MULTIPLICAR:
                mostrarMensaje("La multiplicación es " + Calculadora.multiplicar(fraccionUno, fraccionDos));
                break;
            case DIVIDIR:
                mostrarMensaje("La división es " + Calculadora.dividir(fraccionUno, fraccionDos));
                break;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    private static void realizarOperacionFraccionesMixtas(int opcion, FraccionMixta fraccionMixtaUno, FraccionMixta fraccionMixtaDos) throws Exception {
        switch (opcion) {
            case SUMAR:
                mostrarMensaje("La suma es " + Calculadora.sumar(fraccionMixtaUno, fraccionMixtaDos));
                break;
            case RESTAR:
                mostrarMensaje("La resta es " + Calculadora.restar(fraccionMixtaUno, fraccionMixtaDos));
                break;
            case MULTIPLICAR:
                mostrarMensaje("La multiplicación es " + Calculadora.multiplicarMixto(fraccionMixtaUno, fraccionMixtaDos));
                break;
            case DIVIDIR:
                mostrarMensaje("La división es " + Calculadora.dividirMixto(fraccionMixtaUno, fraccionMixtaDos));
                break;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    private static void realizarOperacionConvertir(int opcion) throws Exception {
        switch (opcion) {
            case CONVERTIR_FRACCIONES:
                Fraccion fraccionUno = crearFraccion();
                mostrarMensaje("La fracción convertida a fracción mixta es " + Calculadora.fraccionAMixta(fraccionUno));
                break;
            case CONVERTIR_FRACCIONES_MIXTAS:
                FraccionMixta fraccionMixtaUno = crearFraccionMixta();
                mostrarMensaje("La fracción mixta convertida a fracción es " + Calculadora.mixtaAFraccion(fraccionMixtaUno));
                break;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    private static Fraccion crearFraccion() throws Exception {
        try {
            long numeradorFraccion = recibirNumero("Ingrese el numerador ");
            long denominadorFraccion = recibirNumero("Ingrese el denominador ");
            return Fraccion.crear(numeradorFraccion, denominadorFraccion);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingrese un número válido.");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error: No se puede crear la fracción. " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Error inesperado al crear la fracción: " + e.getMessage());
        }
    }

    private static FraccionMixta crearFraccionMixta() throws Exception {
        try {
        	long parteEntera = recibirNumero("Ingrese la parte entera ");
        	long numeradorFraccion = recibirNumero("Ingrese el numerador ");
            long denominadorFraccion = recibirNumero("Ingrese el denominador ");
            
            return FraccionMixta.crear(numeradorFraccion, denominadorFraccion, parteEntera);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingrese un número válido.");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error: No se puede crear la fracción mixta. " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Error inesperado al crear la fracción mixta: " + e.getMessage());
        }
    }

    private static int mostrarMenuPrincipal() {
        return JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, MENU, MENU[0]);
    }

    private static int mostrarMenuOpciones() {
        return JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPCIONES, OPCIONES[0]);
    }

    private static int mostrarMenuConvertir() {
        return JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, CONVERTIR_OPCIONES, CONVERTIR_OPCIONES[0]);
    }

    private static int recibirNumero(String mensaje) throws NumberFormatException {
        try {
            String numeroTexto = JOptionPane.showInputDialog(null, mensaje);
            return Integer.parseInt(numeroTexto);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingrese un número válido.");
        }
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
