package in.keepgrowing.interviewcodingquestions.algorithms.sorting.quicksort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortImplementationTest {

    private QuickSortImplementation demo;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{}, new int[]{}),
                Arguments.arguments(new int[]{1}, new int[]{1}),
                Arguments.arguments(new int[]{10, 89}, new int[]{10, 89}),
                Arguments.arguments(new int[]{9, 0, 13}, new int[]{0, 9, 13}),
                Arguments.arguments(new int[]{0, 10, 89, 0}, new int[]{0, 0, 10, 89}),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}),
                Arguments.arguments(new int[]{-4, 3, 2, 1}, new int[]{-4, 1, 2, 3}),
                Arguments.arguments(new int[]{9, 9, 1, 2, 2, 3, 100}, new int[]{1, 2, 2, 3, 9, 9, 100}),
                Arguments.arguments(new int[]{9, 1, 2, -2, 3}, new int[]{-2, 1, 2, 3, 9}),
                Arguments.arguments(new int[]{9, 9, 1, 3, 100, 100}, new int[]{1, 3, 9, 9, 100, 100})
        );
    }

    @BeforeEach
    void setUp() {
        demo = new QuickSortImplementation();
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldQuickSortWithFirstElementAsPivot(int[] numbers, int[] expected) {
        int[] actual = demo.sortWithFirstElementAsPivot(numbers, 0, numbers.length - 1);

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldQuickSortWithLastElementAsPivot(int[] numbers, int[] expected) {
        int[] actual = demo.sortWithLastElementAsPivot(numbers, 0, numbers.length - 1);

        assertArrayEquals(expected, actual);
    }
}