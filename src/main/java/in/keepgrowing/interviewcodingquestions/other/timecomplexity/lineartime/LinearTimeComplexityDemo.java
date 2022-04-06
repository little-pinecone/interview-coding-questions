package in.keepgrowing.interviewcodingquestions.other.timecomplexity.lineartime;

import java.util.List;

public class LinearTimeComplexityDemo {

    public Integer findElementIndexWithLinearSearch(int[] numbers, int elementValue) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == elementValue) {
                return i;
            }
        }
        return -1;
    }

    public Integer sumElements(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .sum();
    }
}
