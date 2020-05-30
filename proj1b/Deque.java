public interface Deque<T> {
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item);

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item);

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty();

    /** Returns the number of items in the deque. */
    public int size();

    /** Print the items in the deque from first to last. */
    public void printDeque();

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst();

    /** Removes and returns the item at the back of the deque. */
    public T removeLast();

    /** Gtes the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exits,returns null.
     * Must not alter the deque. */
    public T get(int index);

    /** Same as get, but uses recursion. */
    /** A helper method. */
    public T getRecursive(int index);
}
