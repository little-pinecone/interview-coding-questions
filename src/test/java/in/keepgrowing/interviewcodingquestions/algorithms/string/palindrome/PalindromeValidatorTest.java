package in.keepgrowing.interviewcodingquestions.algorithms.string.palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeValidatorTest {

    private PalindromeValidator palindromeValidator;

    @BeforeEach
    void setUp() {
        palindromeValidator = new PalindromeValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "b",
            "bbbb",
            "kayak",
            "123321",
            "22022022",
            "madam",
            "racecar"
    })
    void shouldReturnTrueForValidPalindromes(String  input) {
        assertTrue(palindromeValidator.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "  ",
            "ak",
            "123421",
            "mad1am"
    })
    void shouldReturnFalseForInvalidPalindromes(String  input) {
        assertFalse(palindromeValidator.isValid(input));
    }
}