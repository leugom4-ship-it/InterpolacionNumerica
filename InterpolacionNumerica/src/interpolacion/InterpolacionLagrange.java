package interpolacion;

public class InterpolacionLagrange {

    private static void validarDatos(double[] x, double[] y) {

        if (x == null || y == null ||
                x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException(
                    "Los arreglos no pueden estar vacios."
            );
        }

        if (x.length != y.length) {
            throw new IllegalArgumentException(
                    "Los arreglos deben tener el mismo tamaño."
            );
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    throw new IllegalArgumentException(
                            "Existen nodos x repetidos."
                    );
                }
            }
        }
    }

    public static double interpolacionLagrange(
            double[] x, double[] y, double xEval) {

        validarDatos(x, y);

        int n = x.length;
        double resultado = 0.0;

        for (int i = 0; i < n; i++) {

            double termino = y[i];

            for (int j = 0; j < n; j++) {

                if (i != j) {

                    // Formula del producto base Li(x)
                    termino *= (xEval - x[j]) /
                            (x[i] - x[j]);
                }
            }

            resultado += termino;
        }

        return resultado;
    }
}