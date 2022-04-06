package in.keepgrowing.interviewcodingquestions.algorithms.search.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchImplementationTest {

    private BinarySearchImplementation demo;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(new int[]{17}, 17, 0),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 3, 2),
                Arguments.arguments(new int[]{1, 7, 16, 32, 45, 78, 198, 215, 294}, 78, 5),
                Arguments.arguments(new int[]{15, 27, 33, 49, 89}, 89, 4),
                Arguments.arguments(new int[]{15, 27, 33, 49, 89}, 15, 0),
                Arguments.arguments(new int[]{1, 2, 2, 4}, 2, 1)
        );
    }

    private static Stream<Arguments> getInvalidData() {
        return Stream.of(
                Arguments.arguments(new int[]{}, 1),
                Arguments.arguments(new int[]{17}, 18),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 0),
                Arguments.arguments(new int[]{1, 7, 16, 32, 45, 78, 198, 215, 294}, 666)
        );
    }

    @BeforeEach
    void setUp() {
        demo = new BinarySearchImplementation();
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldFindElementIndexWithBinarySearch(int[] sortedNumbers, int elementValue, Integer expected) {
        Integer index = demo.findElementIndexWithBinarySearch(sortedNumbers, elementValue);

        assertEquals(expected, index);
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidData")
    void shouldNotFindNotExistingElement(int[] sortedNumbers, int elementValue) {
        Integer index = demo.findElementIndexWithBinarySearch(sortedNumbers, elementValue);

        assertNull(index);
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldFindElementIndexWithJavaArrayBinarySearch(int[] sortedNumbers, int elementValue, Integer expected) {
        Integer index = demo.findElementIndexWithJavaArrayBinarySearch(sortedNumbers, elementValue);

        assertEquals(expected, index);
    }

    @ParameterizedTest
    @MethodSource(value = "getInvalidData")
    void shouldNotFindNotExistingElementWithJavaArrayBinarySearch(int[] sortedNumbers, int elementValue) {
        Integer index = demo.findElementIndexWithJavaArrayBinarySearch(sortedNumbers, elementValue);

        assertNull(index);
    }

    @Test
    void shouldFindElementIndexWithJavaCollectionsBinarySearch() {
        List<Integer> sortedNumbers = new ArrayList<>(List.of(15, 27, 33, 49, 89));
        Integer index = demo.findElementIndexWithJavaCollectionBinarySearch(sortedNumbers, 89);

        assertEquals(4, index);
    }

    @Test
    void shouldNotFindNotExistingElementIndexWithJavaCollectionsBinarySearch() {
        List<Integer> sortedNumbers = new ArrayList<>(List.of());
        Integer index = demo.findElementIndexWithJavaCollectionBinarySearch(sortedNumbers, 89);

        assertNull(index);
    }
}