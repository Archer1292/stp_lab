import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * @author Bratus Nadja on 11/14/2017
 * @project stp
 */
public class HelloWorldTest {
    @Test
    public void main() throws Exception {
    }

    @Test
    public void print() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HelloWorld.print(new PrintStream(out));
        String s = out.toString();
        Assert.assertEquals("1",s);
    }

}