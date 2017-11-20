import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * @author Bratus Nadja on 11/14/2017
 * @project lab2
 */
public class MatrixTest {
    private Matrix m;
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    @Before
    public void setUp(){
        double[][] mat={
                {1.0,2.0,4.0,6.0},
                {-1.0,50.0,0.0,0.0},
                {1.0,-5.0,0.0,0.0},
                {1.0,10.0,-61.0,0.0}
        };
        m=new Matrix(mat);
    }



    @Test
    public void print() throws Exception {
        log.clearLog();
        m.print();
        String expect = "1.0 2.0 4.0 6.0 \n-1.0 50.0 0.0 0.0 \n1.0 -5.0 0.0 0.0 \n1.0 10.0 -61.0 0.0";
        assertEquals(expect,log.getLog().trim());
        m = new Matrix();

        log.clearLog();
        m.print();
        expect = "Order of matrix 0. The size of the matrix is 0x0";
        assertEquals(expect,log.getLog().trim());
    }

    @Test
    public void doRowsGrow() throws Exception {
    }

    @Test
    public void solveExpression() throws Exception {
    }

}