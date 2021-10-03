import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    public void test2dContructor() {
        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        Matrix A = new Matrix(valsA);
        assertEquals(valsA, A.getMatrix());
    }

}
