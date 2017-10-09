import org.junit.Test;
import org.junit.Assert;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;



public class MyTest {
    @Test
    public void name() throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HelloWorld.print(new PrintStream(out));
        String s = out.toString();
        Assert.assertEquals("1",s);
    }
}
