package in.keepgrowing.interviewcodingquestions.algorithms.math.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceGeneratorTest {

    private FibonacciSequenceGenerator sequenceGenerator;

    static Stream<Arguments> getListData() {
        return Stream.of(
                Arguments.arguments(1, List.of(1)),
                Arguments.arguments(3, List.of(1, 1, 2)),
                Arguments.arguments(12, List.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144))
        );
    }

    static Stream<Arguments> getArrayData() {
        return Stream.of(
                Arguments.arguments(1, new int[]{1}),
                Arguments.arguments(3, new int[]{1, 1, 2}),
                Arguments.arguments(12, new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144})
        );
    }

    static Stream<Arguments> getStringData() {
        return Stream.of(
                Arguments.arguments(1, "1"),
                Arguments.arguments(3, "1, 1, 2"),
                Arguments.arguments(12, "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144")
        );
    }

    @BeforeEach
    void setUp() {
        sequenceGenerator = new FibonacciSequenceGenerator();
    }

    @ParameterizedTest
    @MethodSource("getListData")
    void shouldGenerateList(int length, List<Integer> expected) {
        var actual = sequenceGenerator.generateList(length);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldNotGenerateListFromInvalidLength(int length) {
        var actual = sequenceGenerator.generateList(length);

        assertTrue(actual.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("getArrayData")
    void shouldGenerateArray(int length, int[] expected) {
        int[] actual = sequenceGenerator.generateArray(length);

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldNotGenerateArrayFromInvalidLength(int length) {
        int[] actual = sequenceGenerator.generateArray(length);

        assertEquals(0, actual.length);
    }

    @ParameterizedTest
    @MethodSource("getStringData")
    void shouldGenerateString(int length, String expected) {
        var actual = sequenceGenerator.generateString(length);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints={-1, 0})
    void shouldNotGenerateStringFromInvalidLength(int length) {
        var actual = sequenceGenerator.generateString(length);

        assertEquals("", actual);
    }
}