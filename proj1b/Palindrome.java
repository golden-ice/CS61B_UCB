public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque = new  LinkedListDeque<>();
        for (int i = 0; i < word.length(); i ++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /** To judge whether a word is a palindrome. */
    /** A helper method for isPalindrome(String word). */
    private boolean isCharEqual(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        Character cFirst = wordDeque.removeFirst();
        Character cLast = wordDeque.removeLast();
        return cFirst.equals(cLast) && isCharEqual(wordDeque);
    }

    public boolean isPalindrome(String word) {
        return isCharEqual(wordToDeque(word));
    }

    /** To judge whether a word is a palindrome--Off by One. */
    /** A helper method for isPalindrome(String word, CharacterComparator cc). */
    private boolean isCharEqual(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        Character cFirst = wordDeque.removeFirst();
        Character cLast = wordDeque.removeLast();
        return cc.equalChars(cFirst, cLast) && isCharEqual(wordDeque, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isCharEqual(wordToDeque(word), cc);
    }

}
