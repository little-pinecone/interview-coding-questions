package in.keepgrowing.interviewcodingquestions.algorithms.search.linearsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearSearchImplementationTest {

    private LinearSearchImplementation linearSearch;

    private static Stream<Arguments> getInvalidData() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(1, 2, 3)),
                Arguments.arguments(List.of(17))
        );
    }

    @BeforeEach
    void setUp() {
        linearSearch = new LinearSearchImplementation();
    }

    @Test
    void shouldFindElementIndex() {
        int[] numbers = {12, 76, 1, 0};

        Integer actual = linearSearch.findElementIndex(numbers, 1);

        assertEquals(2, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidData")
    void shouldNotFindNotExistingElement(List<Integer> numbers) {
        int[] numbersAsArray = numbers.stream()
                .mapToInt(n -> n)
                .toArray();

        Integer actual = linearSearch.findElementIndex(numbersAsArray, 100);

        assertEquals(-1, actual);
    }
}