package in.keepgrowing.interviewcodingquestions.datastructures.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class QueueExample {

    public Queue<Integer> fromRange(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = start; i <= end; i++) {
            queue.add(i);
        }

        return queue;
    }

    public Deque<Integer> fromList(List<Integer> elements) {
        return new ArrayDeque<>(elements);
    }
}
