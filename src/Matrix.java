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
}
