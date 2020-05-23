public class LinkedListDeque<T> {
    private DequeNode sentinel;
    private int size;

    private class DequeNode {
        private DequeNode prev;
        private T item;
        private DequeNode next;

        private DequeNode(DequeNode p, T i, DequeNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Creates a linked list deque with x. */
    public LinkedListDeque(T item) {
        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new DequeNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev.next = new DequeNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
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
        DequeNode thisNode = sentinel;
        //if (size == 0) {
        //    System.out.println("Empty Deque");
        //}
        for (int i = 0; i < size; i++) {
            thisNode = thisNode.next;
            System.out.print(thisNode.item + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        T toRemoveFirst = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemoveFirst;
    }

    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        T toRemoveBack = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemoveBack;
    }

    /** Gtes the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exits,returns null.
     * Must not alter the deque. */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        DequeNode toGet = sentinel.next;
        int i = 0;
        while (i < index) {
            toGet = toGet.next;
        }
        return toGet.item;
    }

    /** Same as get, but uses recursion. */
    /** A helper method. */
    private T getRecursive(int index, DequeNode thisNode) {
        if (index >= size) {
            return null;
        }
        if (index == 0) {
            return thisNode.item;
        }
        return getRecursive(index - 1, thisNode.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    /** Create a deep copy of other */
    /** This is an additional task in sp19, which is not included in sp18. */
    //@Josh Hug
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i)); // need a cast (T), since the type of other is unknown.
        }
    }

//    public static void main (String[] args) {
//        LinkedListDeque L = new LinkedListDeque();
//        LinkedListDeque<String> M = new LinkedListDeque<>("Star");
//        M.addFirst("Team");
//        M.addFirst("Last");
//        M.addFirst("Missa");
//        M.size();
//        L.printDeque();
//        M.printDeque();
//        M.removeFirst();
//        M.printDeque();
//        M.removeLast();
//        M.printDeque();
//    }
}
