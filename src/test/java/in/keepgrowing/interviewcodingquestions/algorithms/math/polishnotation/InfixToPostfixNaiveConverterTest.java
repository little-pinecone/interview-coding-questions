package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixNaiveConverterTest {

    private InfixToPostfixNaiveConverter infixToPostfix;

    @BeforeEach
    void setUp() {
        infixToPostfix = new InfixToPostfixNaiveConverter();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a+b, ab+",
            "(a+b), ab+",
            "a*(b+c), abc+*",
            "a+b*c-d, abc*+d-",
            "a+b*(c^d-e)^(f+g*h)-i, abcd^e-fgh*+^*+i-",
            "a+b*c-(d+e)*f, abc*+de+f*-"
    })
    void shouldConvert(String original, String expected) {
        String actual = infixToPostfix.convert(original);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(a+b",
            "a+b)",
            "a+(b-c"
    })
    void shouldThrowExceptionOnInvalidExpression(String original) {
        assertThrows(IllegalArgumentException.class, () -> infixToPostfix.convert(original));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void shouldNotConvertEmptyInput(String input) {
        String actual = infixToPostfix.convert(input);

        assertTrue(actual.isBlank());
    }
}