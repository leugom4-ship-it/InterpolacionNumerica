package interpolacion;

public class InterpolacionNewton {

    private static void validarDatos(double[] x, double[] y) {

        if (x == null || y == null ||
                x.length == 0 || x.length != y.length) {
            throw new IllegalArgumentException(
                    "Los arreglos x y deben ser validos."
            );
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    throw new IllegalArgumentException(
                            "No se permiten nodos repetidos."
                    );
                }
            }
        }
    }

    public static double[][] tablaDiferencias(
            double[] x, double[] y) {

        validarDatos(x, y);

        int n = x.length;
        double[][] tabla = new double[n][n];

        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {

                tabla[i][j] =
                        (tabla[i + 1][j - 1] -
                                tabla[i][j - 1]) /
                                (x[i + j] - x[i]);
            }
        }

        return tabla;
    }

    public static double interpolacionNewton(
            double[] x, double[] y, double xEval) {

        double[][] tabla = tablaDiferencias(x, y);

        double resultado = tabla[0][0];
        double producto = 1.0;

        for (int i = 1; i < x.length; i++) {

            producto *= (xEval - x[i - 1]);

            resultado += tabla[0][i] * producto;
        }

        return resultado;
    }

    public static void imprimirTabla(
            double[] x, double[][] tabla) {

        System.out.println(
                "\nTABLA DE DIFERENCIAS DIVIDIDAS"
        );

        System.out.printf("%8s %12s", "x", "f[x]");

        for (int j = 1; j < x.length; j++) {
            System.out.printf("%12s", "Orden " + j);
        }

        System.out.println();

        for (int i = 0; i < x.length; i++) {

            System.out.printf("%8.2f", x[i]);

            for (int j = 0; j < x.length - i; j++) {
                System.out.printf(
                        "%12.6f", tabla[i][j]
                );
            }

            System.out.println();
        }
    }
}