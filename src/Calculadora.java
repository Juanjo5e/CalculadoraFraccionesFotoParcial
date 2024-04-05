public class Calculadora {

    private Calculadora() {
        super();
    }

    public static long calcularMcd(Fraccion fraccion) {
    	if(fraccion == null) 
    		throw new IllegalArgumentException("Las fraccion no pueden estar vacía");
        long numerador = fraccion.getNumerador();
        long denominador = fraccion.getDenominador();

        while (denominador != 0) {
            long auxiliar = denominador;
            denominador = numerador % denominador;
            numerador = auxiliar;
        }

        return numerador;
    }

    public static Fraccion simplificar(Fraccion fraccion) {
    	if(fraccion == null) 
    		throw new IllegalArgumentException("Las fraccion no pueden estar vacía");
        long mcd = calcularMcd(fraccion);
        long numeradorSimplificado = fraccion.getNumerador() / mcd;
        long denominadorSimplificado = fraccion.getDenominador() / mcd;
        return Fraccion.crear(numeradorSimplificado, denominadorSimplificado);
    }

    public static Fraccion sumar(Fraccion fraccionUno, Fraccion fraccionDos) {
        if (fraccionUno == null ) {
            throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
        }
        if (fraccionDos == null ) {
            throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
        }

        long numerador = fraccionUno.getNumerador() * fraccionDos.getDenominador()
                + fraccionUno.getDenominador() * fraccionDos.getNumerador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getDenominador();

        return simplificar(Fraccion.crear(numerador, denominador));
    }

    public static Fraccion convertirAFraccion(FraccionMixta mixto) {
        long numerador = (mixto.getParteEntera() * mixto.getDenominador()) + mixto.getNumerador();
        long denominador = mixto.getDenominador();
        return simplificar(Fraccion.crear(numerador, denominador));
    }

    public static FraccionMixta convertirAMixta(Fraccion fraccion) {
        long numeradorImpropio = fraccion.getNumerador() % fraccion.getDenominador();
        long denominador = fraccion.getDenominador();
        long parteEntera = fraccion.getNumerador() / fraccion.getDenominador();

        if (parteEntera != 0) {
            return FraccionMixta.crear(parteEntera, numeradorImpropio, denominador);
        } else {
            return FraccionMixta.crear(0, numeradorImpropio, denominador);
        }
    }

    public static FraccionMixta sumar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
        
    	  if (mixtoUno == null ) {
              throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
          }
          if (mixtoDos == null ) {
              throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
          }


        Fraccion fraccionConverUno = simplificar(convertirAFraccion(mixtoUno));
        Fraccion fraccionConverDos = simplificar(convertirAFraccion(mixtoDos));
        Fraccion fraccionOperada = sumar(fraccionConverUno, fraccionConverDos);
        FraccionMixta fraccion = convertirAMixta(fraccionOperada);
        
        return fraccion;
    }

    public static Fraccion restar(Fraccion fraccionUno, Fraccion fraccionDos) {
    	  if (fraccionUno == null ) {
              throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
          }
          if (fraccionDos == null ) {
              throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
          }


        long numerador = fraccionUno.getNumerador() * fraccionDos.getDenominador()
                - fraccionUno.getDenominador() * fraccionDos.getNumerador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getDenominador();

        return simplificar(Fraccion.crear(numerador, denominador));
    }

    public static Fraccion multiplicar(Fraccion fraccionUno, Fraccion fraccionDos) {
    	  if (fraccionUno == null ) {
              throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
          }
          if (fraccionDos == null ) {
              throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
          }


        long numerador = fraccionUno.getNumerador() * fraccionDos.getNumerador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getDenominador();

        return simplificar(Fraccion.crear(numerador, denominador));
    }

    public static Fraccion dividir(Fraccion fraccionUno, Fraccion fraccionDos) {
    	  if (fraccionUno == null ) {
              throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
          }
          if (fraccionDos == null ) {
              throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
          }


        long numerador = fraccionUno.getNumerador() * fraccionDos.getDenominador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getNumerador();

        return simplificar(Fraccion.crear(numerador, denominador));
    }

    public static FraccionMixta restar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
    	  if (mixtoUno == null ) {
              throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
          }
          if (mixtoDos == null ) {
              throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
          }


        Fraccion fraccionConverUno = simplificar(convertirAFraccion(mixtoUno));
        Fraccion fraccionConverDos = simplificar(convertirAFraccion(mixtoDos));
        Fraccion fraccionOperada = restar(fraccionConverUno, fraccionConverDos);
        FraccionMixta fraccion = convertirAMixta(fraccionOperada);
        return fraccion;
    }

    public static FraccionMixta multiplicar(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
    	if (mixtoUno == null ) {
            throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
        }
        if (mixtoDos == null ) {
            throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
        }


        Fraccion fraccionConverUno = simplificar(convertirAFraccion(mixtoUno));
        Fraccion fraccionConverDos = simplificar(convertirAFraccion(mixtoDos));
        Fraccion fraccionOperada = multiplicar(fraccionConverUno, fraccionConverDos);
        FraccionMixta fraccion = convertirAMixta(fraccionOperada);
        return fraccion;
    }

    public static FraccionMixta dividir(FraccionMixta mixtoUno, FraccionMixta mixtoDos) {
    	if (mixtoUno == null ) {
            throw new IllegalArgumentException("Las fraccion Uno no pueden estar vacía");
        }
        if (mixtoDos == null ) {
            throw new IllegalArgumentException("Las fraccion Dos no pueden estar vacía");
        }


        Fraccion fraccionConverUno = simplificar(convertirAFraccion(mixtoUno));
        Fraccion fraccionConverDos = simplificar(convertirAFraccion(mixtoDos));
        Fraccion fraccionOperada = dividir(fraccionConverUno, fraccionConverDos);
        FraccionMixta fraccion = convertirAMixta(fraccionOperada);
        return fraccion;
    }

    public static Fraccion amplificar(Fraccion fraccion, long constanteAmplificador) {
        if (fraccion == null) {
            throw new IllegalArgumentException("La fracción no puede estar vacía");
        }
        if (constanteAmplificador == 0) {
            throw new IllegalArgumentException("El constante amplificador no puede ser 0");
        }

        long nuevoNumerador = fraccion.getNumerador() * constanteAmplificador;
        long nuevoDenominador = fraccion.getDenominador() * constanteAmplificador;
        return Fraccion.crear(nuevoNumerador, nuevoDenominador);
    }

    public static boolean esPropia(Fraccion fraccion) {
        if (fraccion == null) {
            throw new IllegalArgumentException("La fracción no puede estar vacía");
        }

        if (fraccion.getNumerador() < fraccion.getDenominador()) {
            return true;
        } else {
            return false;
        }
    }
}
