import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class ArraySolverTest {
    private static ArraySolver as;

    @BeforeClass
    public static void setUp(){
        int[] arr= {-1,2,-3,4,1,1};
        as = new ArraySolver(arr);
    }
    @AfterClass
    public static void tearDown(){as=null;}

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();


    @Test
    public void getInputNumber(){


        systemInMock.provideLines("2\n");
        assertEquals(2,ArraySolver.getInputNumber() );

        log.clearLog();
        systemInMock.provideLines("-9\n");
        assertEquals(-9, ArraySolver.getInputNumber());

        log.clearLog();
        systemInMock.provideLines("r\n3");
        assertEquals(3, ArraySolver.getInputNumber());
        assertEquals("Sorry, that's not a number.", log.getLog().trim());
    }

    @Test
    public void countPositive() {

        assertEquals(4,as.countPositive() );

    }

    @Test
    public void getMaxMin(){
        int[] res = as.getMaxMin();
        assertEquals(4,res[0]);
        assertEquals(-3,res[1]);
    }

    @Test
    public void sum(){assertEquals(4,as.sum()); }

    @Test
    public void sumOfNegative() {assertEquals(-4,as.sumOfNegative()); }

    @Test
    public void sumElementsIndexIsMultiple3( ){assertEquals(4,as.sumElementsIndexIsMultiple3()); }

    @Test
    public void productLargestSmallestElements() {
        assertEquals(-12,as.productLargestSmallestElements());
    }
    @Test
    public void getGeometricMean() {
        assertEquals(3.464101615137755,as.getGeometricMean(),0.000000000000001);
    }

}