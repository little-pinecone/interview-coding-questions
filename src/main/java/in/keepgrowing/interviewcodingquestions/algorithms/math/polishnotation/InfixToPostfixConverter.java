package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import in.keepgrowing.interviewcodingquestions.algorithms.math.other.MathExpressionSplitter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * This implementation works both for expressions written with letters and numbers, e.g. {@code 11+2-3+4} and
 * {@code a+b*c-d}
 */
public class InfixToPostfixConverter {

    private static final int ADD_OR_SUBTRACT = 2;
    private static final int MULTIPLE_OR_DIVIDE = 3;
    private static final int POWER = 4;
    private static final Map<String, Integer> OPERATOR_PRECEDENCE = Map.of(
            "+", ADD_OR_SUBTRACT,
            "-", ADD_OR_SUBTRACT,
            "*", MULTIPLE_OR_DIVIDE,
            "/", MULTIPLE_OR_DIVIDE,
            "^", POWER);
    private static final String NUMBER_SEPARATOR = " ";

    private final MathExpressionSplitter splitter;

    public InfixToPostfixConverter(MathExpressionSplitter splitter) {
        this.splitter = splitter;
    }

    public String convert(String original) {
        if (isInvalid(original)) {
            return "";
        }
        var result = new StringBuilder();
        Deque<String> operators = new ArrayDeque<>();
        List<String> parsed = splitter.split(original);
        parsed.forEach(element -> {
            if (Parenthesis.isOpening(element)) {
                operators.push(element);
            } else if (Parenthesis.isClosing(element)) {
                while (openingParenthesisNotFound(operators)) {
                    result.append(operators.pop());
                }
                if (foundOpeningParenthesis(operators)) {
                    operators.pop();
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else if (isOperator(element)) {
                while (shouldTakePreviousOperators(operators, element)) {
                    result.append(operators.pop());
                }
                operators.push(element);
            } else {
                result.append(NUMBER_SEPARATOR);
                result.append(element);
            }
        });
        validateOperators(operators);
        operators.forEach(result::append);

        return result.toString().stripLeading();
    }

    private boolean isInvalid(String original) {
        return null == original || original.isBlank();
    }

    private boolean foundOpeningParenthesis(Deque<String> operators) {
        return !operators.isEmpty() && Parenthesis.isOpening(operators.peek());
    }

    private boolean openingParenthesisNotFound(Deque<String> operators) {
        return !(operators.isEmpty() || Parenthesis.isOpening(operators.peek()));
    }

    private boolean isOperator(String element) {
        return OPERATOR_PRECEDENCE.containsKey(element);
    }

    private boolean shouldTakePreviousOperators(Deque<String> operators, String current) {
        return !operators.isEmpty() && previousGetsPrecedence(operators.peek(), current);
    }

    private boolean previousGetsPrecedence(String previous, String current) {
        return !Parenthesis.isOpening(previous)
                && (OPERATOR_PRECEDENCE.get(previous) >= OPERATOR_PRECEDENCE.get(current));
    }

    private void validateOperators(Deque<String> operators) {
        if (operators.contains(Parenthesis.OPENING.getValue())) {
            throw new IllegalArgumentException("Mismatched parentheses");
        }
    }
}
