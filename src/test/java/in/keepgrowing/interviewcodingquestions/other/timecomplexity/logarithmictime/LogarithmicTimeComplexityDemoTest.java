package in.keepgrowing.interviewcodingquestions.other.timecomplexity.logarithmictime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LogarithmicTimeComplexityDemoTest {

    private LogarithmicTimeComplexityDemo demo;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{17}, 17, 0),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 3, 2),
                Arguments.arguments(new int[]{1, 7, 16, 32, 45, 78, 198, 215, 294}, 78, 5),
                Arguments.arguments(new int[]{15, 27, 33, 49, 89}, 89, 4),
                Arguments.arguments(new int[]{15, 27, 33, 49, 89}, 15, 0)
        );
    }

    private static Stream<Arguments> getInvalidData() {
        return Stream.of(
                Arguments.arguments(new int[]{17}, 18),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 0),
                Arguments.arguments(new int[]{1, 7, 16, 32, 45, 78, 198, 215, 294}, 666)
        );
    }

    @BeforeEach
    void setUp() {
        demo = new LogarithmicTimeComplexityDemo();
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldFindElementIndexWithBinarySearch(int[] sortedNumbers, int elementValue, Integer expected) {
        Integer index = demo.findElementIndexWithBinarySearch(sortedNumbers, elementValue);

        assertEquals(expected, index);
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidData")
    void shouldNotFindIndexOfNonExistingElement(int[] sortedNumbers, int elementValue) {
        Integer index = demo.findElementIndexWithBinarySearch(sortedNumbers, elementValue);

        assertNull(index);
    }
}