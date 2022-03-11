package in.keepgrowing.interviewcodingquestions.algorithms.math.other;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Splits a mathematical operation into a list of operators and operands.
 * e.g. {@code "1+2"} will be split into {@code ["1", "+", "2"]}
 */
public class MathExpressionSplitter {

    /**
     * This pattern uses two capturing groups:
     * <p>
     *     <ul>
     *         <li>1st alternative for numbers</li>
     *         <li>2nd alternative for anything but numbers and whitespaces</li>
     *     </ul>
     * </p>
     */
    private static final Pattern EXPRESSION_PART_PATTERN = Pattern.compile("(\\d+|[^ 0-9])");

    public List<String> split(String expression) {
        if (null == expression) {
            return List.of();
        }
        Matcher matcher = EXPRESSION_PART_PATTERN.matcher(expression);
        var parsedExpression = new LinkedList<String>();
        while (matcher.find()) {
            parsedExpression.add(matcher.group(1));
        }

        return parsedExpression;
    }
}
