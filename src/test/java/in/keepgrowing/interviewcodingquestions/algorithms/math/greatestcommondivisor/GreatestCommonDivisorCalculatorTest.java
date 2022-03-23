package in.keepgrowing.interviewcodingquestions.algorithms.math.greatestcommondivisor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreatestCommonDivisorCalculatorTest {

    private GreatestCommonDivisorCalculator calculator;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(2, new int[]{2, 4, 6, 8}),
                Arguments.arguments(21, new int[]{462, 1071}),
                Arguments.arguments(4, new int[]{8, 12, 20}),
                Arguments.arguments(9, new int[]{99, 126, 369}),
                Arguments.arguments(8, new int[]{0, 8}),
                Arguments.arguments(1, new int[]{0, 0, 1, 0}),
                Arguments.arguments(0, new int[]{0, 0, 0})
        );
    }

    @BeforeEach
    void setUp() {
        calculator = new GreatestCommonDivisorCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 4, 2",
            "-2, -4, 2",
            "0, 4, 4",
            "4, 0, 4",
            "0, 0, 0",
            "42, 56, 14",
            "566, 18478, 2",
            "1071, 462, 21"
    })
    void shouldCalculateRecursively(int firstNumber, int secondNumber, int expected) {
        int actual = calculator.calculateRecursively(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void shouldCalculate(int expected, int... numbers) {
        int actual = calculator.calculate(numbers);
        assertEquals(expected, actual);
    }
}