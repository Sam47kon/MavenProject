package JavaHeadFirstAndOther.Matrix;

import java.util.Objects;

public class MultiplyMatrix {

    /**
     * MultiplyMatrix multiplication method.
     *
     * @param m1 Multiplicand множимое
     * @param m2 Multiplier множитель
     * @return Product произведение матрицы m1 на m2
     */
    private static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length  количество столбцов m1
        int m2RowLength = m2.length;    // m2 rows length     количество строк m2
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    private static String toString(double[][] m) {
        StringBuilder result = new StringBuilder();
        for (double[] doubles : m) {
            for (double aDouble : doubles) {
                result.append(String.format("%11.2f", aDouble));
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // #1
        double[][] multiplicand = new double[][]{
                {3, -1, 2},
                {2, 0, 1},
                {1, 2, 1}
        };
        double[][] multiplier = new double[][]{
                {2, -1, 1},
                {0, -2, 3},
                {3, 0, 1}
        };
        System.out.println("#1\n" + toString(Objects.requireNonNull(multiplyByMatrix(multiplicand, multiplier))));
        // #2
        multiplicand = new double[][]{
                {1, 2, 0},
                {-1, 3, 1},
                {2, -2, 1}
        };
        multiplier = new double[][]{
                {2},
                {-1},
                {1}
        };
        System.out.println("#2\n" + toString(Objects.requireNonNull(multiplyByMatrix(multiplicand, multiplier))));
        // #3
        multiplicand = new double[][]{
                {1, 2, -1},
                {0, 1, 0}
        };
        multiplier = new double[][]{
                {1, 1, 0, 0},
                {0, 2, 1, 1},
                {1, 1, 2, 2}
        };
        System.out.println("#3\n" + toString(Objects.requireNonNull(multiplyByMatrix(multiplicand, multiplier))));
    }
}