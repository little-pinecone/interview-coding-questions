package in.keepgrowing.interviewcodingquestions.algorithms.math.fibonacci;

import java.util.LinkedList;
import java.util.List;

public class FibonacciSequenceGenerator {

    public List<Integer> generateList(int length) {
        var sequence = new LinkedList<Integer>();
        if (length <= 0) {
            return sequence;
        }
        sequence.add(1);
        int counter = length - 1;
        var previous = 0;
        var current = 1;
        while (counter > 0) {
            current += previous;
            previous = current - previous;
            sequence.add(current);
            counter--;
        }

        return sequence;
    }

    public int[] generateArray(int length) {
        if (length <= 0) {
            return new int[0];
        }
        int[] sequence = new int[length];
        sequence[0] = 1;
        int counter = length - 1;
        int previous = 0;
        int current = 1;
        int index = 1;
        while (counter > 0) {
            current += previous;
            previous = current - previous;
            sequence[index] = current;
            index++;
            counter--;
        }

        return sequence;
    }
}
