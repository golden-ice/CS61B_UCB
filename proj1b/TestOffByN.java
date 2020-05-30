import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void TestOffByFive() {
        OffByN ob5 = new OffByN(5);
        assertTrue(ob5.equalChars('a','f'));
        assertTrue(ob5.equalChars('f','a'));
        assertTrue(ob5.equalChars('m','r'));
        assertFalse(ob5.equalChars('y','m'));
        assertFalse(ob5.equalChars('a','a'));
        assertFalse(ob5.equalChars('&','%'));
    }

    @Test
    public void TestOffByThree() {
        OffByN ob5 = new OffByN(3);
        assertTrue(ob5.equalChars('a','d'));
        assertTrue(ob5.equalChars('d','a'));
        assertTrue(ob5.equalChars('m','p'));
        assertFalse(ob5.equalChars('y','m'));
        assertFalse(ob5.equalChars('a','a'));
        assertFalse(ob5.equalChars('&','%'));
    }
}
