import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MatrixTest {

    @Test
    public void test2dContructor() {
        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(valsA);
        assertEquals(valsA, A.getMatrix());
    }

    @Test
    public void test2dContructorException() {
        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                double[][] valsA = { { 1., 2. }, { 4., 5., 6. }, { 7., 8., 9. } };
                Matrix A = new Matrix(valsA);
            }
        });
    }
}
