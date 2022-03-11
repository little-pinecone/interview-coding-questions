package in.keepgrowing.interviewcodingquestions.algorithms.math.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathExpressionSplitterTest {

    private MathExpressionSplitter splitter;

    private static Stream<Arguments> getExpressionData() {
        return Stream.of(
                Arguments.arguments("", List.of()),
                Arguments.arguments("1+2", List.of("1", "+", "2")),
                Arguments.arguments(" 1 + 2 - 3", List.of("1", "+", "2", "-", "3")),
                Arguments.arguments("11+22", List.of("11", "+", "22")),
                Arguments.arguments("1+22*123456-0", List.of("1", "+", "22", "*", "123456", "-", "0")),
                Arguments.arguments("(1+2)", List.of("(", "1", "+", "2", ")")),
                Arguments.arguments("2*(1+2)", List.of("2", "*", "(", "1", "+", "2", ")")),
                Arguments.arguments("(1+2)^3", List.of("(", "1", "+", "2", ")", "^", "3")),
                Arguments.arguments("a+b*c-d", List.of("a", "+", "b", "*", "c", "-", "d")),
                Arguments.arguments("2*a+c-d", List.of("2", "*", "a", "+", "c", "-", "d")),
                Arguments.arguments("((1+2)*3)/2", List.of("(", "(", "1", "+", "2", ")", "*", "3", ")", "/", "2"))
        );
    }

    @BeforeEach
    void setUp() {
        splitter = new MathExpressionSplitter();
    }

    @ParameterizedTest
    @MethodSource(value = "getExpressionData")
    void shouldSplitMathematicalExpression(String expression, List<String> expected) {
        var actual = splitter.split(expression);

        assertEquals(expected, actual);
    }
}