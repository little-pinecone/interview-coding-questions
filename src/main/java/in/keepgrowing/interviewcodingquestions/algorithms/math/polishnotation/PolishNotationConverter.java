package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import in.keepgrowing.interviewcodingquestions.algorithms.math.other.MathExpressionSplitter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

public class PolishNotationConverter {

    public static final int ADD_OR_SUBTRACT = 2;
    public static final int MULTIPLE_OR_DIVIDE = 3;
    public static final int POWER = 4;
    private static final Map<String, Integer> OPERATOR_PRECEDENCE = Map.of(
            "+", ADD_OR_SUBTRACT,
            "-", ADD_OR_SUBTRACT,
            "*", MULTIPLE_OR_DIVIDE,
            "/", MULTIPLE_OR_DIVIDE,
            "^", POWER);
    private static final String OPENING_PARENTHESIS = "(";
    private static final String CLOSING_PARENTHESIS = ")";

    private final MathExpressionSplitter splitter;

    public PolishNotationConverter(MathExpressionSplitter splitter) {
        this.splitter = splitter;
    }

    public String infixToPostfix(String original) {
        if (null == original || original.isBlank()) {
            return "";
        }
        var operators = new ArrayDeque<String>();
        var result = new StringBuilder();
        List<String> parsed = splitter.split(original);
        parsed.forEach(element -> {
            if (OPENING_PARENTHESIS.equals(element)) {
                operators.push(element);
            } else if (CLOSING_PARENTHESIS.equals(element)) {
                while (!(operators.isEmpty() || OPENING_PARENTHESIS.equals(operators.peek()))) {
                    result.append(operators.pop());
                }
                if (!operators.isEmpty() && OPENING_PARENTHESIS.equals(operators.peek())) {
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
                result.append(" ");
                result.append(element);
            }
        });
        if (operators.contains(OPENING_PARENTHESIS)) {
            throw new IllegalArgumentException("Mismatched parentheses");
        }
        operators.forEach(result::append);

        return result.toString().stripLeading();
    }

    private boolean isOperator(String element) {
        return OPERATOR_PRECEDENCE.containsKey(element);
    }

    private boolean shouldTakePreviousOperators(ArrayDeque<String> previousOperators, String current) {
        return !previousOperators.isEmpty() && previousGetsPrecedence(previousOperators.peek(), current);
    }

    private boolean previousGetsPrecedence(String previous, String current) {
        return !OPENING_PARENTHESIS.equals(previous)
                && (OPERATOR_PRECEDENCE.get(previous) >= OPERATOR_PRECEDENCE.get(current));
    }
}
