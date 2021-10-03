public class Matrix {
    double[][] A;

    /*
     * Construct a matrix from a 2-D array.
     * 
     * Parameters: A - Two-dimensional array of doubles.
     */
    public Matrix(double[][] A) {
        int rowLength = A[0].length;
        for (int i = 1; i < A.length; i++) {
            if (rowLength != A[i].length) {
                throw new IllegalArgumentException("All rows must have the same length");

            }
        }
        this.A = A;
    }

    /*
     * Access the internal two-dimensional array.
     * 
     * Returns: Pointer to the two-dimensional array of matrix elements.
     */
    public double[][] getArray() {
        return this.A;
    }

    /*
     * Linear algebraic matrix multiplication, A * B
     * 
     * Parameters: B - another matrix Returns: Matrix product, A * B
     */
    public Matrix times(Matrix B) {
        double[][] bArr = B.getArray();
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
