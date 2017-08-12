package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

/**
 * Matrix Library
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_33 {

    public static void main(String[] args) {
        dot(null, null);
    }

    //Vector dot product
    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) return Double.NaN;

        double result = 0.0f;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    //Matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null || a.length != b.length || a[0].length != b[0].length) return null;

        double[][] result = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] + b[k][j];
                }
            }
        }
        return result;
    }

    //transpose
    public static double[][] transpose(double[][] a) {
        if (a == null) return null;

        double[][] result = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }

    //matrix-vector product
    public static double[] mult(double[][] a, double[] x) {
        if (a == null || x == null || a[0].length != x.length) return null;

        double[] result = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i] += a[i][j] * x[j];
            }
        }

        return result;
    }

    //vector- matrix product
    public static double[] mult(double[] y, double[][] a) {
        if (y == null || a == null || y.length != a.length) return null;

        double[] result = new double[a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i] += y[j] * a[j][i];
            }
        }
        return result;
    }
}

