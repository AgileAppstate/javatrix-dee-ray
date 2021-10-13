public class Matrix {

		//Changed our double values to private to encapsulate our data fields to avoid unwanted tampering.	

		private double[][] A; 
		private int m;	
		private int n;	

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
				// setting m & n
				this.m = A.length;
				this.n = A[0].length;

				this.A = A;
		}

		/*
		 * Construct a m x n constant matrix.
		 *
		 * Parameter m: # of rows
		 * Parameter n: # of cols
		 * Parameter d: constant double
		 */ 
		public Matrix(int m, int n, double d) {
				this.m = m; // "this" references our hidden data fields we initialized at the beginning
				this.n = n;
				this.A = new double[m][n];
				for (int i = 0; i < m; i++) {
						for (int j = 0; j < n; j++) {
								A[i][j] = d;
						}
				}
		}
		/*
		 *  Construct matrix fast w/o checking args
		 *
		 *
		 */
		public Matrix (double[][] A, int m, int n) {
				this.A = A;
				this.m = m;
				this.n = n;
		}
		/*
		 * Construct an m by n matrix of zeros.
		 *  
		 * 
		 */
		public Matrix(int m, int n) {

				this.m = m;
				this.n = n;
				A = new double[m][n];

		}
		/*
		 * Construct a matrix from 1D array
		 * 
		 *
		 */

		public Matrix (double[] vals, int m) {

				this.m = m;
				this.n = (m != 0 ? vals.length/m : 0);
				if (m * this.n != vals.length) {
						throw new IllegalArgumentException("Array length has to be a multiple of m.");
				}

				this.A = new double[m][this.n];
				for (int i = 0; i < this.m; i++) {
						for (int j=0; j < this.n; j++) {
								A[i][j] = vals[i + j * m];
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
		 * Parameters: w - number of items we want to print
		 * d - "d" number of decimal places
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
		/* 
		 *	Transpose method
		 *
		 *  Taking rows & columns and swapping them within each other. 	
		 */ 
		public Matrix transpose () {	
				double[][] x = new double[m][m];

				for(int i=0; i<this.m; i++) {
						for(int j=0; j<this.n; j++) {
								x[i][j] = A[j][i];
						}
				}
				return new Matrix(x);

		}	
}
