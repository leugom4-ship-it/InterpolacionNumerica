package interpolacion;

public class Main {

    public static void main(String[] args) {

        // Datos iniciales
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 4, 9, 16};

        // Punto donde evaluaremos
        double xEval = 2.5;

        System.out.println("==================================");
        System.out.println(" PRACTICA UNIDAD 5");
        System.out.println(" INTERPOLACION NUMERICA");
        System.out.println(" LAGRANGE Y NEWTON");
        System.out.println("==================================");

        // Metodo de Lagrange
        double resultadoLagrange =
                InterpolacionLagrange.interpolacionLagrange(
                        x, y, xEval
                );

        // Metodo de Newton
        double[][] tabla =
                InterpolacionNewton.tablaDiferencias(x, y);

        InterpolacionNewton.imprimirTabla(x, tabla);

        double resultadoNewton =
                InterpolacionNewton.interpolacionNewton(
                        x, y, xEval
                );

        // Mostrar resultados
        System.out.println("\nRESULTADOS FINALES");

        System.out.printf(
                "Punto evaluado: %.4f%n", xEval
        );

        System.out.printf(
                "Resultado Lagrange: %.10f%n",
                resultadoLagrange
        );

        System.out.printf(
                "Resultado Newton: %.10f%n",
                resultadoNewton
        );

        System.out.printf(
                "Diferencia absoluta: %.12f%n",
                Math.abs(resultadoLagrange - resultadoNewton)
        );

        System.out.printf(
                "Valor exacto esperado: %.10f%n",
                xEval * xEval
        );

        System.out.println("==================================");
    }
}