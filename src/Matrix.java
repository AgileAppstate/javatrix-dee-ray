public class Matrix {

	private double[][] A;
	private double m;
	private double n;

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

		this.m = A.length;
		this.n = A[0].length;

		this.A = A;
	}

	/*
	 * Construct a m x n constant matrix.
	 *
	 * Parameter m: # of rows Parameter n: # of cols Parameter d: constant double
	 */
	public Matrix(int m, int n, double d) {
		this.m = m;
		this.n = n;
		this.A = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = d;
			}
		}
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
	 * Get a submatrix.
	 * 
	 * Parameters: i0 - Initial row index i1 - Final row index j0 - Initial column
	 * index j1 - Final column index
	 * 
	 * Returns: A(i0:i1,j0:j1)
	 */
	public Matrix getMatrix(int i0, int i1, int j0, int j1) {
		if (i1 + 1 > m || j1 + 1 > n) {
			throw new ArrayIndexOutOfBoundsException("Submatrix indices");
		}
		double[][] arr = new double[i1 + 1][j1 + 1];
		double[][] matrix = getArray();
		int row = 0, col;
		for (int i = i0; i <= i1; i++) {
			col = 0;
			for (int j = j0; j <= j1; j++) {
				arr[row][col] = matrix[i][j];
				col++;
			}
			row++;
		}
		return new Matrix(arr);
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

	/*
	 * Print method
	 *
	 * Parameters: w - number of items we want to print d - "d" number of decimal
	 * places
	 */
	public void print(int w, int d) {
		int count = 0; // only printing items we want ("w"), instead of all items
		String format = "%." + d + "f "; // print each column to "d" number of decimal places
		for (int row = 0; row < this.m; row++) {
			for (int col = 0; col < this.n; col++) {
				if (count <= w) {
					System.out.printf(format, this.A[row][col]); // desired print formatting
					count++;
				} else {
					break;
				}
			}
			System.out.println();
		}
	}
}
