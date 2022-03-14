package in.keepgrowing.interviewcodingquestions.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackExampleTest {

    private Deque<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackExample().fromRange(1, 4);
    }

    @Test
    void shouldAddNewElements() {
        stack.push(300);

        assertEquals("[300, 4, 3, 2, 1]", stack.toString());
    }

    @Test
    void shouldViewContent() {
        assertEquals("[4, 3, 2, 1]", stack.toString());

        assertEquals(4, stack.peek());
        assertEquals(4, stack.peekFirst());
        assertEquals(1, stack.peekLast());
        assertTrue(stack.contains(1));
    }

    @Test
    void shouldIterateStartingFromHead() {
        List<Integer> result = new ArrayList<>();
        stack.forEach(result::add);

        assertEquals(List.of(4, 3, 2, 1), result);
    }

    @Test
    void shouldRemoveElementsFromHead() {
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pollFirst());
        assertEquals(2, stack.poll());
    }

    @Test
    void shouldRemoveElements() {
        while (!stack.isEmpty()) {
            stack.pop();
        }

        assertThrows(NoSuchElementException.class, stack::pop);
        assertNull(stack.poll());
    }
}