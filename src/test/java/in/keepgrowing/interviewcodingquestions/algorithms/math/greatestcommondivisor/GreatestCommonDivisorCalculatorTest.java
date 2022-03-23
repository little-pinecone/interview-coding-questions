package in.keepgrowing.interviewcodingquestions.algorithms.math.greatestcommondivisor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreatestCommonDivisorCalculatorTest {

    private GreatestCommonDivisorCalculator calculator;

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
            "566, 18478, 2"
    })
    void shouldCalculate(int firstNumber, int secondNumber, int expected) {
        int actual = calculator.calculateRecursively(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}