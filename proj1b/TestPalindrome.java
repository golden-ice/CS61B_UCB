import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("raceCAR"));
        assertFalse(palindrome.isPalindrome("Mike"));
        assertFalse(palindrome.isPalindrome("horse"));
    }

    @Test
    public void TestOffByOnePalindrome() {
        OffByOne Obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("", Obo));
        assertTrue(palindrome.isPalindrome("a", Obo));
        assertTrue(palindrome.isPalindrome("flake", Obo));
        assertTrue(palindrome.isPalindrome("mpqn", Obo));
        assertTrue(palindrome.isPalindrome("nqpm", Obo));
        assertTrue(palindrome.isPalindrome("nqm", Obo));
        assertFalse(palindrome.isPalindrome("hike", Obo));
        assertFalse(palindrome.isPalindrome("dream", Obo));
    }
}