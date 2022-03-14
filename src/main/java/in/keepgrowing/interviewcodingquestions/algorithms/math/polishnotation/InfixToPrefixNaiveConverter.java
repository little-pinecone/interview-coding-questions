package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

/**
 * This is a simplified implementation that works only for expression written with letters, e.g. {@code a*(b+c)}
 */
public class InfixToPrefixNaiveConverter {

    private final InfixToPostfixConverter infixToPostfixConverter;

    public InfixToPrefixNaiveConverter(InfixToPostfixConverter infixToPostfixConverter) {
        this.infixToPostfixConverter = infixToPostfixConverter;
    }

    public String convert(String original) {
        if (null == original || original.isBlank()) {
            return "";
        }
        var reversed = new StringBuilder(original).reverse().toString();
        var withFixedParenthesis = reversed
                .replace('(', '<')
                .replace(')', '(')
                .replace('<', ')');
        String postfix = infixToPostfixConverter.convert(withFixedParenthesis);

        return new StringBuilder(postfix).reverse().toString();
    }
}
