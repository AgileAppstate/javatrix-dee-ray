public class Testtrix {
    public static void main(String[] args) {
        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(valsA);
        Matrix x = new Matrix(3, 1, 1.);
        Matrix b = A.times(x);
		b.print(9, 1);
		A.print(9, 1);
    }
}
