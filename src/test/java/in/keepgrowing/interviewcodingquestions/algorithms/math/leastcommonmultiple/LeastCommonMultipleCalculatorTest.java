package in.keepgrowing.interviewcodingquestions.algorithms.math.leastcommonmultiple;

import in.keepgrowing.interviewcodingquestions.algorithms.math.greatestcommondivisor.GreatestCommonDivisorCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeastCommonMultipleCalculatorTest {

    private LeastCommonMultipleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new LeastCommonMultipleCalculator(new GreatestCommonDivisorCalculator());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4, 6, 12",
            "5, 7, 35"
    })
    void shouldCalculate(int firstNumber, int secondNumber, int expected) {
        int actual = calculator.calculate(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}