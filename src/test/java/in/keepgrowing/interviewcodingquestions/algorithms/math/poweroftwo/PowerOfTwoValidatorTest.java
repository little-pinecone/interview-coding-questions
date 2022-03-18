package in.keepgrowing.interviewcodingquestions.algorithms.math.poweroftwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoValidatorTest {

    private PowerOfTwoValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PowerOfTwoValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, false",
            "2, true",
            "7, false",
            "32, true",
            "512, true",
            "513, false"
    })
    void shouldTestIfNumberIsPowerOfTwo(int number, boolean expected) {
        boolean actual = validator.validate(number);

        assertEquals(expected, actual);
    }
}