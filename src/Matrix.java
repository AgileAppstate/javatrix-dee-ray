public class Matrix {
    double[][] A;

    public Matrix(double[][] A) {
        int rowLength = A[0].length;
        for (int i = 1; i < A.length; i++) {
            if (rowLength != A[i].length) {
                throw new IllegalArgumentException("All rows must have the same length");

            }
        }
        this.A = A;
    }

    public double[][] getMatrix() {
        return this.A;
    }

    public Matrix times(Matrix B) {
        double[][] bArr = B.getMatrix();
        if (A[0].length != bArr.length) {
            throw new IllegalArgumentException("Matrix inner dimensions must agree.");
        }
        double[][] res = new double[A.length][bArr[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < bArr[0].length; j++) {
                for (int k = 0; k < bArr.length; k++) {
                    res[i][j] += A[i][k] * bArr[k][j];
                }
            }
        }
        return new Matrix(res);
    }
}
