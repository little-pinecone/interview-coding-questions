package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InfixToPrefixNaiveConverterTest {

    @Mock
    private InfixToPostfixConverter infixToPostfix;

    private InfixToPrefixNaiveConverter infixToPrefix;

    @BeforeEach
    void setUp() {
        infixToPrefix = new InfixToPrefixNaiveConverter(infixToPostfix);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a+b, b+a, ba+, +ab",
            "(a+b), (b+a), ba+, +ab",
            "a*(b+c), (c+b)*a, cb+a*, *a+bc",
            "a+b*(c^d-e), (e-d^c)*b+a, edc^-b*a+, +a*b-^cde"
    })
    void shouldConvertInfixToPrefix(String original, String reversed, String postfix, String expected) {
        when(infixToPostfix.convert(reversed))
                .thenReturn(postfix);

        String actual = infixToPrefix.convert(original);

        assertEquals(expected, actual);
    }
}