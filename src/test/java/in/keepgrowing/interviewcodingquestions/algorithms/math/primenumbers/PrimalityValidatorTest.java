package in.keepgrowing.interviewcodingquestions.algorithms.math.primenumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PrimalityValidatorTest {

    private PrimalityValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PrimalityValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, false",
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "7, true",
            "8, false",
            "13, true",
            "89, true",
            "97, true",
    })
    void shouldValidate(int number, boolean expected) {
        boolean actual = validator.validate(number);

        assertEquals(expected, actual);
    }
}