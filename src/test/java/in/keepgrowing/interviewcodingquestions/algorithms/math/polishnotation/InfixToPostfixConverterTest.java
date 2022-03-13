package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import in.keepgrowing.interviewcodingquestions.algorithms.math.other.MathExpressionSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InfixToPostfixConverterTest {

    private InfixToPostfixConverter infixToPostfix;

    @Mock
    private MathExpressionSplitter expressionSplitter;

    private static Stream<Arguments> getSupportedInput() {
        return Stream.of(
                Arguments.arguments("1+2",
                        List.of("1", "+", "2"),
                        "1 2+"),
                Arguments.arguments("11+2-3+4",
                        List.of("11", "+", "2", "-", "3", "+", "4"),
                        "11 2+ 3- 4+"),
                Arguments.arguments("(11+12)",
                        List.of("(", "11", "+", "12", ")"),
                        "11 12+"),
                Arguments.arguments("a+b*c-d",
                        List.of("a", "+", "b", "*", "c", "-", "d"),
                        "a b c*+ d-"),
                Arguments.arguments("3+4×(2−1)",
                        List.of("3", "+", "4", "*", "(", "2", "-", "1", ")"),
                        "3 4 2 1-*+"),
                Arguments.arguments("11+2*3-(4+5)*2",
                        List.of("11", "+", "2", "*", "3", "-", "(", "4", "+", "5", ")", "*", "2"),
                        "11 2 3*+ 4 5+ 2*-")
        );
    }

    private static Stream<Arguments> getInputWithMismatchedParentheses() {
        return Stream.of(
                Arguments.arguments("1+2)",
                        List.of("1", "+", "2", ")")),
                Arguments.arguments("1+(2",
                        List.of("1", "+", "(", "2")),
                Arguments.arguments("(1+2",
                        List.of("(", "1", "+", "2"))
        );
    }

    private static Stream<Arguments> getUnsupportedInput() {
        return Stream.of(
                Arguments.arguments("(1-5)^2^3",
                        List.of("(", "1", "-", "5", ")", "^", "2", "^", "3"),
                        "1 5- 2 3^^"),
                Arguments.arguments("3+4*2/(1-5)^2^3",
                        List.of("3", "+", "4", "*", "2", "/", "(", "1", "-", "5", ")", "^", "2", "^", "3"),
                        "3 4 2* 1 5- 2 3^^/+")
        );
    }

    @BeforeEach
    void setUp() {
        infixToPostfix = new InfixToPostfixConverter(expressionSplitter);
    }

    @ParameterizedTest
    @MethodSource(value = "getSupportedInput")
    void shouldConvert(String original, List<String> parsed, String expected) {
        when(expressionSplitter.split(original))
                .thenReturn(parsed);

        String actual = infixToPostfix.convert(original);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "getInputWithMismatchedParentheses")
    void shouldThrowExceptionOnParenthesisMismatch(String input, List<String> parsed) {
        when(expressionSplitter.split(input))
                .thenReturn(parsed);

        assertThrows(RuntimeException.class, () -> infixToPostfix.convert(input));
    }

    @ParameterizedTest
    @MethodSource(value = "getUnsupportedInput")
    void documentUnSupportedInput(String original, List<String> parsed, String expected) {
        when(expressionSplitter.split(original))
                .thenReturn(parsed);

        String actual = infixToPostfix.convert(original);

        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void shouldNotConvertEmptyInput(String input) {
        String actual = infixToPostfix.convert(input);

        assertTrue(actual.isBlank());
    }
}