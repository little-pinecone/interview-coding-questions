package in.keepgrowing.interviewcodingquestions.other.timecomplexity.constanttime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantTimeComplexityDemoTest {

    private ConstantTimeComplexityDemo demo;

    @BeforeEach
    void setUp() {
        demo = new ConstantTimeComplexityDemo();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 4, 16",
            "1, 2, 8, 64"
    })
    void shouldSumArithmeticSeries() {
        int actual = demo.sumArithmeticSeries(1, 2, 8);

        assertEquals(64, actual);
    }

    @Test
    void shouldChangeLinkedListContent() {
        List<Integer> actual = demo.changeLinkedListContent();

        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldGetElementFromArray() {
        String actual = demo.getElementFromArrayList();

        assertEquals("first", actual);
    }

    @Test
    void shouldGetLengthOfArray() {
        int actual = demo.getLengthOfArray();

        assertEquals(3, actual);
    }

    @Test
    void shouldPrintNumber() {
        demo.printNumber();
    }

    @Test
    void shouldOperateOnSet() {
        Set<Integer> actual = demo.operateOnSet();

        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldCheckMapContent() {
        Map<String, String> actual = demo.checkMapContent();

        assertEquals(1, actual.size());
    }

    @Test
    void shouldOperateOnQueue() {
        Queue<Integer> actual = demo.operateOnQueue();

        assertTrue(actual.isEmpty());
    }
}