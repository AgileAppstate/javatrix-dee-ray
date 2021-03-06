import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MatrixTest {

    @Test
    public void test2dContructor() {
        double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(vals);
        assertEquals(vals, A.getArray());
    }

    @Test
    public void Matrix() {
        double[][] vals = { { 2.0 }, { 2.0 }, { 2.0 } };
        Matrix B = new Matrix(3, 1, 2.0);
        assertArrayEquals(vals, B.getArray());
    }

    @Test
    public void test2dContructorException() {
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                double[][] vals = { { 1., 2. }, { 4., 5., 6. }, { 7., 8., 9. } };

                Matrix A = new Matrix(vals);
            }
        });
    }

    @Test
    public void testTimes() {
        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        double[][] valsB = { { 1. }, { 1. }, { 1. } };
        double[][] expectedRes = { { 6. }, { 15. }, { 24. } };

        Matrix A = new Matrix(valsA);
        Matrix x = new Matrix(valsB);
        Matrix b = A.times(x);
        double[][] res = b.getArray();
        assertArrayEquals(expectedRes, res);

    }

    @Test
    public void testTimesException() {
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
                double[][] valsB = { { 1. }, { 1. }, { 1. }, { 1. } };

                Matrix A = new Matrix(valsA);
                Matrix x = new Matrix(valsB);
                Matrix b = A.times(x);
            }
        });
    }

    @Test
    public void testGetMatrix() {
        double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        double[][] subVals = { { 1. }, { 4. } };
        Matrix A = new Matrix(vals);
        Matrix B = A.getMatrix(0, 1, 0, 0);
        assertArrayEquals(subVals, B.getArray());
    }

    @Test
    public void testSetMatrix() {
        double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } }, subVals = { { 10. }, { 24. } };
        double[][] correctVals = { { 10., 2., 3 }, { 24., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(vals);
        A.setMatrix(0, 1, 0, 0, new Matrix(subVals));
        assertArrayEquals(correctVals, A.getArray());
    }

    @Test
    public void testSetMatrixException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } }, subVals = { { 10. }, { 24. } };
                Matrix A = new Matrix(vals);
                A.setMatrix(0, 3, 0, 0, new Matrix(subVals));
            }
        });

    }

    @Test
    public void testGetMatrixException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
                double[][] subVals = { { 1. }, { 4. } };
                Matrix A = new Matrix(vals);
                Matrix B = A.getMatrix(0, 3, 0, 0);
            }
        });

    }

    @Test
    public void printTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // reading console output
        PrintStream output = System.out; // reading console output

        double[][] vals = { { 6.0 }, { 6.0 }, { 6.0 } };
        Matrix A = new Matrix(vals);
        String right = "6.0 \n6.0 \n6.0 \n"; // expected result

        System.setOut(new PrintStream(baos));

        A.print(3, 1); // 3 items, 1 decimal place

        System.out.flush();
        String test = baos.toString();
        System.setOut(output);
        assertEquals(right, test);
    }

    @Test
    public void transposeTest() {

        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        double[][] expectedRes = { { 1., 4., 7. }, { 2., 5., 8. }, { 3., 6., 9. } };

        Matrix A = new Matrix(valsA);
        Matrix b = A.transpose();
        double[][] res = b.getArray();
        assertArrayEquals(expectedRes, res);

    }

    @Test
    public void noArgMatrixTest() {
        try {
            Matrix test = new Matrix(new double[][] { { 1., 2., 3. }, { 4, 5, 6 } }, 1, 2);
        } catch (Exception e) {
            assertEquals("Error generated, unchecked constructor", e);
        }
    }

    @Test
    public void zeroMatrixTest() {

        double[][] A = { { 0., 0., 0. }, { 0., 0., 0. } };
        Matrix l = new Matrix(2, 3);
        double[][] res = l.getArray();
        assertArrayEquals(A, res);

    }

    @Test
    public void oneDimArrMatrixTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // reading console output
        PrintStream output = System.out;
        double[] A = { 1.0, 2.0, 3.0 };
        int m = 3;
        double[][] B = { { 1. }, { 2. }, { 3. } };
        Matrix k = new Matrix(A, m);
        double[][] res = k.getArray();
        assertArrayEquals(B, res);
    }
}
