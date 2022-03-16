package in.keepgrowing.interviewcodingquestions.algorithms.math.factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCalculatorTest {

    private FactorialCalculator generator;

    @BeforeEach
    void setUp() {
        generator = new FactorialCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "8, 40320"
    })
    void shouldCompute(int input, int expected) {
        int actual = generator.calculate(input);

        assertEquals(expected, actual);
    }
}