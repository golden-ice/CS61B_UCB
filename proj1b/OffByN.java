public class OffByN implements CharacterComparator {
    private int diffIn;

    public OffByN(int N) {
        diffIn =  N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == diffIn || diff == -diffIn) {
            return true;
        }
        return false;
    }
}
