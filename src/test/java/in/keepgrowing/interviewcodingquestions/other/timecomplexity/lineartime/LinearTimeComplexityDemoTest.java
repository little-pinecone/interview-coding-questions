package in.keepgrowing.interviewcodingquestions.other.timecomplexity.lineartime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearTimeComplexityDemoTest {

    private LinearTimeComplexityDemo demo;

    private static Stream<Arguments> getInvalidData() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(1, 2, 3)),
                Arguments.arguments(List.of(17))
        );
    }

    @BeforeEach
    void setUp() {
        demo = new LinearTimeComplexityDemo();
    }

    @Test
    void shouldFindElementIndex() {
        int[] numbers = {12, 76, 1, 0};

        Integer actual = demo.findElementIndexWithLinearSearch(numbers, 1);

        assertEquals(2, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidData")
    void shouldNotFindNotExistingElement(List<Integer> numbers) {
        int[] numbersAsArray = numbers.stream()
                .mapToInt(n -> n)
                .toArray();

        Integer actual = demo.findElementIndexWithLinearSearch(numbersAsArray, 100);

        assertEquals(-1, actual);
    }

    @Test
    void shouldSumElements() {
        Integer actual = demo.sumElements(List.of(1, 7, 18));

        assertEquals(26, actual);
    }
}