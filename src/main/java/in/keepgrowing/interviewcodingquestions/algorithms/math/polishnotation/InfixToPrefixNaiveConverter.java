package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

/**
 * This is a simplified implementation that works only for expression written with letters, e.g. {@code a*(b+c)}
 */
public class InfixToPrefixNaiveConverter {

    private final InfixToPostfixNaiveConverter infixToPostfixConverter;

    public InfixToPrefixNaiveConverter(InfixToPostfixNaiveConverter infixToPostfixConverter) {
        this.infixToPostfixConverter = infixToPostfixConverter;
    }

    public String convert(String original) {
        if (null == original || original.isBlank()) {
            return "";
        }
        String postfix = infixToPostfixConverter.convert(reverse(original));

        return new StringBuilder(postfix).reverse().toString();
    }

    private String reverse(String original) {
        var reversed = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            if (original.charAt(i) == '(') {
                reversed.append(')');
            } else if (original.charAt(i) == ')') {
                reversed.append('(');
            } else reversed.append(original.charAt(i));
        }
        return reversed.toString();
    }
}
