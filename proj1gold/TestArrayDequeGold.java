import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {
    @Test
    public void testArrayDequeGold() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad = new ArrayDequeSolution<>();

        // test addLast
        for (int i = 0; i < 20; i++) {
            int ranNum = StdRandom.uniform(50);
            stu.addLast(ranNum);
            sad.addLast(ranNum);
        }
        for (int i = 0; i < 20; i++) {
            int expected = sad.get(i);
            int actual = stu.get(i);
            /**
             *  @source AssertEqualsStringDemo
             */
            assertEquals("Oh noooo!\nThis is bad with the method addLast:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // test addFirst
        for (int i = 0; i < 20; i++) {
            int ranNum = StdRandom.uniform(50);
            stu.addFirst(ranNum);
            sad.addFirst(ranNum);
        }
        for (int i = 0; i < 20; i++) {
            int expected = sad.get(i);
            int actual = stu.get(i);
            /**
             *  @source AssertEqualsStringDemo
             */
            assertEquals("Oh noooo!\nThis is bad with the method addFirst:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                            expected, actual);
        }


        // test removeFirst
        for (int i = 0; i < 20; i++) {
            Integer expected = sad.removeFirst();
            Integer actual = stu.removeFirst();
            /**
             *  @source AssertEqualsStringDemo
             */
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // test removeLast
        for (int i = 0; i < 20; i++) {
            Integer expected = sad.removeLast();
            Integer actual = stu.removeLast();
            /**
             *  @source AssertEqualsStringDemo
             */
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }
    }

    @Test
    public void testArrayDequeGold2() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad = new ArrayDequeSolution<>();

        int ranNum1 =StdRandom.uniform(50);
        stu.addFirst(ranNum1);
        sad.addFirst(ranNum1);
        assertEquals("addFirst(" + ranNum1 + ")", sad.get(0), stu.get(0));
        System.out.println("addFirst(" + ranNum1 + ")");

        int ranNum2 =StdRandom.uniform(50);
        stu.addLast(ranNum2);
        sad.addLast(ranNum2);
        assertEquals("addLast(" + ranNum2 + ")", sad.get(1), stu.get(1));
        System.out.println("addLast(" + ranNum2 + ")");

        Integer actual1 = stu.removeFirst();
        Integer expected1 = sad.removeFirst();
        assertEquals("removeFirst()", expected1, actual1);
        System.out.println("removeFirst()");

        Integer actual2 = stu.removeLast();
        Integer expected2 = sad.removeLast();
        assertEquals("removeLast()", expected2, actual2);
        System.out.println("removeLast()");

    }
}
