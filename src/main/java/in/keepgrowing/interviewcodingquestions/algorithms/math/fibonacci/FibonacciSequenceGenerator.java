package in.keepgrowing.interviewcodingquestions.algorithms.math.fibonacci;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class FibonacciSequenceGenerator {

    public List<Integer> generateList(int length) {
        List<Integer> sequence = new LinkedList<>();
        if (length <= 0) {
            return sequence;
        }
        sequence.add(1);
        int counter = length - 1;
        int previous = 0;
        int current = 1;
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

    public String generateString(int length) {
        if (length <= 0) {
            return "";
        }
        StringJoiner output = new StringJoiner(", ");
        output.add("1");
        int previous = 0;
        int current = 1;
        for (int i = 0; i < length - 1; i++) {
            current += previous;
            previous = current - previous;
            output.add(String.valueOf(current));
        }

        return output.toString();
    }
}
