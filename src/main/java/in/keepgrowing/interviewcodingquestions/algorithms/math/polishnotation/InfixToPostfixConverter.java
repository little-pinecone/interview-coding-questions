package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import in.keepgrowing.interviewcodingquestions.algorithms.math.other.MathExpressionSplitter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

public class InfixToPostfixConverter {

    public static final int ADD_OR_SUBTRACT = 2;
    public static final int MULTIPLE_OR_DIVIDE = 3;
    public static final int POWER = 4;
    private static final Map<String, Integer> OPERATOR_PRECEDENCE = Map.of(
            "+", ADD_OR_SUBTRACT,
            "-", ADD_OR_SUBTRACT,
            "*", MULTIPLE_OR_DIVIDE,
            "/", MULTIPLE_OR_DIVIDE,
            "^", POWER);

    private final MathExpressionSplitter splitter;

    public InfixToPostfixConverter(MathExpressionSplitter splitter) {
        this.splitter = splitter;
    }

    public String convert(String original) {
        if (null == original || original.isBlank()) {
            return "";
        }
        var operators = new ArrayDeque<String>();
        var result = new StringBuilder();
        List<String> parsed = splitter.split(original);
        parsed.forEach(element -> {
            if (Parenthesis.isOpening(element)) {
                operators.push(element);
            } else if (Parenthesis.isClosing(element)) {
                while (!(operators.isEmpty() || Parenthesis.isOpening(operators.peek()))) {
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
                result.append(" ");
                result.append(element);
            }
        });
        validateOperators(operators);
        operators.forEach(result::append);

        return result.toString().stripLeading();
    }

    private boolean foundOpeningParenthesis(ArrayDeque<String> operators) {
        return !operators.isEmpty() && Parenthesis.isOpening(operators.peek());
    }

    private boolean isOperator(String element) {
        return OPERATOR_PRECEDENCE.containsKey(element);
    }

    private boolean shouldTakePreviousOperators(ArrayDeque<String> previousOperators, String current) {
        return !previousOperators.isEmpty() && previousGetsPrecedence(previousOperators.peek(), current);
    }

    private boolean previousGetsPrecedence(String previous, String current) {
        return !Parenthesis.isOpening(previous)
                && (OPERATOR_PRECEDENCE.get(previous) >= OPERATOR_PRECEDENCE.get(current));
    }

    private void validateOperators(ArrayDeque<String> operators) {
        if (operators.contains(Parenthesis.OPENING.getValue())) {
            throw new IllegalArgumentException("Mismatched parentheses");
        }
    }
}
