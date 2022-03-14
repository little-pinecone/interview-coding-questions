package in.keepgrowing.interviewcodingquestions.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackExample {

    public Deque<Integer> fromRange(int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = start; i <= end; i++) {
            stack.push(i);
        }

        return stack;
    }
}
