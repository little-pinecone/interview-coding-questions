package in.keepgrowing.interviewcodingquestions.other.timecomplexity.lineartime;

import java.util.List;

public class LinearTimeComplexityDemo {

    public Integer sumElements(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .sum();
    }
}
