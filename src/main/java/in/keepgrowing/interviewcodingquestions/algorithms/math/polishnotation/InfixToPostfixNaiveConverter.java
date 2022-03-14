package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import java.util.ArrayDeque;

/**
 * This is a simplified implementation that works only for expression written with letters, e.g. {@code a*(b+c)}
 */
public class InfixToPostfixNaiveConverter {

    private static int operatorPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 2;
            case '*', '/' -> 3;
            case '^' -> 4;
            default -> 0;
        };
    }

    public String convert(String original) {
        if (null == original) {
            return "";
        }
        var result = new StringBuilder();
        var operators = new ArrayDeque<String>();
        for (int i = 0; i < original.length(); i++) {
            char element = original.charAt(i);
            if (element == '(') {
                operators.push(String.valueOf(element));
            } else if (element == ')') {
                while (!(operators.isEmpty() || "(".equals(operators.peek()))) {
                    result.append(operators.pop());
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                } else {
                    operators.pop();
                }
            } else if (Character.isLetter(element)) {
                result.append(element);
            } else {
                while (!operators.isEmpty() && previousTakesPrecedence(operators.peek(), element)) {
                    result.append(operators.pop());
                }
                operators.push(String.valueOf(element));
            }
        }

        operators.forEach(e -> {
            if ("(".equals(operators.peek())) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            result.append(operators.pop());
        });

        return result.toString();
    }

    private boolean previousTakesPrecedence(String previous, char element) {
        return !"(".equals(previous)
                && operatorPrecedence(previous.charAt(0)) >= operatorPrecedence(element);
    }
}
