package in.keepgrowing.interviewcodingquestions.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueExampleTest {

    private QueueExample queueExample;

    @BeforeEach
    void setUp() {
        queueExample = new QueueExample();
    }

    @Test
    void shouldCreate() {
        var fromRange = queueExample.fromRange(1, 4);
        assertEquals("[1, 2, 3, 4]", fromRange.toString());

        var fromList = queueExample.fromList(List.of(1, 2, 300));
        assertEquals("[1, 2, 300]", fromList.toString());
    }

    @Test
    void shouldAddNewElements() {
        var queue = queueExample.fromRange(1, 2);
        queue.add(300);

        assertEquals("[1, 2, 300]", queue.toString());
    }

    @Test
    void shouldViewContent() {
        var queue = queueExample.fromRange(1, 4);

        assertEquals("[1, 2, 3, 4]", queue.toString());

        assertEquals(1, queue.peek());
        assertTrue(queue.contains(1));
    }

    @Test
    void shouldIterateStartingFromHead() {
        var queue = queueExample.fromRange(1, 4);
        List<Integer> result = new ArrayList<>();

        queue.forEach(result::add);
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    @Test
    void shouldRemoveElementsFromHead() {
        var queue = queueExample.fromRange(1, 4);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.remove());
    }

    @Test
    void shouldRemoveElements() {
        var queue = queueExample.fromRange(1, 4);

        while (!queue.isEmpty()) {
            queue.remove();
        }

        assertThrows(NoSuchElementException.class, queue::remove);
        assertThrows(NoSuchElementException.class, queue::element);
        assertNull(queue.poll());
    }
}