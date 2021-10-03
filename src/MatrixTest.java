import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MatrixTest {

    @Test
    public void test2dContructor() {
        double[][] vals = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(vals);
        assertEquals(vals, A.getArray());
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
}
