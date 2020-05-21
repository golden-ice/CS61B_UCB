public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4; // can be any num in [0, 7]
        nextLast = 5;
    }

    /** Helper method:
     * If the deque has no more space to be filled in, return true, false otherwise.
     */

    private boolean isDeficient() {
        if (size == items.length) {
            return true;
        }
        return false;
    }

    /** Helper method:
     * If the deque has to much space to be left, return true, false otherwise.
     */

    private boolean isSpare() {
        if (items.length >= 16 && items.length > 4 * size) {
            return true;
        }
        return false;
    }

    /** Helper method:
     * Resizes the underlying deque to the target capacity.
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int dequefirst = plusOne(nextFirst);  // get the index of the 1st item
        for (int targerIndex = 0; targerIndex < size; targerIndex++) {
            a[targerIndex] = items[dequefirst];
            dequefirst = plusOne(dequefirst);
        }
        items = a;
        nextFirst = minusOne(0);
        nextLast = plusOne(size - 1);
    }

    /** Compute the index immediately "before" a given index. */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Compute the index immediately "after" a given index. */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }


    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isDeficient()) {
            resize(2 * size);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isDeficient()) {
            resize(2 * size);
        }
        items[nextLast] = item;
        nextFirst = plusOne(nextLast);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Print the items in the deque from first to last. */
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        nextFirst = plusOne(nextFirst);
        T toRemoveFirst = items[nextFirst];
        items[nextFirst] = null; //when emptty, should return null
        if (isSpare()) {
            resize(size / 2);
        }
        if (! isEmpty()) {
            size = size - 1;
        }
        return toRemoveFirst;
    }

    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        nextLast = minusOne(nextLast);
        T toRemoveLast = items[nextLast];
        items[nextLast] = null; //when emptty, should return null
        if (isSpare()) {
            resize(size / 2);
        }
        if (! isEmpty()) {
            size = size - 1;
        }
        return toRemoveLast;
    }

    /** Gtes the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exits,returns null.
     * Must not alter the deque. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int indexStart = plusOne(nextFirst);
        return items[indexStart + index % items.length];
    }

    public ArrayDeque(ArrayDeque other) {
        T[] items = (T[]) new Object[other.items.length];
        size = other.size();
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i)); // need a cast (T), since the type of other is unknown.
        }
    }

    public static void main (String[] args) {
        ArrayDeque L = new ArrayDeque();
        L.addFirst("Team");
        L.addFirst("Last");
        L.addFirst("Missa");
        L.size();
        L.printDeque();
        L.removeFirst();
        L.printDeque();
        L.removeLast();
        L.printDeque();
    }
}
