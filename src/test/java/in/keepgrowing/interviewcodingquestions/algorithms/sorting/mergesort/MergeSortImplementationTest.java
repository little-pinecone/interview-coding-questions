package in.keepgrowing.interviewcodingquestions.algorithms.sorting.mergesort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortImplementationTest {

    MergeSortImplementation demo;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{}, new int[]{}),
                Arguments.arguments(new int[]{1}, new int[]{1}),
                Arguments.arguments(new int[]{10, 89}, new int[]{10, 89}),
                Arguments.arguments(new int[]{9, 0, 13}, new int[]{0, 9, 13}),
                Arguments.arguments(new int[]{0, 10, 89, 0}, new int[]{0, 0, 10, 89}),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}),
                Arguments.arguments(new int[]{-4, 3, 2, 1}, new int[]{-4, 1, 2, 3}),
                Arguments.arguments(new int[]{9, 9, 1, 2, 2, 3, 100}, new int[]{1, 2, 2, 3, 9, 9, 100})
        );
    }

    @BeforeEach
    void setUp() {
        demo = new MergeSortImplementation();
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void ShouldMergeSort(int[] numbers, int[] expected) {
        int[] actual = demo.sort(numbers);

        assertArrayEquals(expected, actual);
    }
}