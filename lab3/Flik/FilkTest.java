import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {
    @Test
    public void testFilk() {
        assertTrue("True",Flik.isSameNumber(3, 3));
        assertTrue("False",Flik.isSameNumber(128, 128));
        //assertTrue("False",Flik.isSameNumber(0, 5));
    }
}
