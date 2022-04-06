package in.keepgrowing.interviewcodingquestions.other.timecomplexity.lineartime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearTimeComplexityDemoTest {

    private LinearTimeComplexityDemo demo;

    @BeforeEach
    void setUp() {
        demo = new LinearTimeComplexityDemo();
    }

    @Test
    void shouldSumElements() {
        Integer actual = demo.sumElements(List.of(1, 7, 18));

        assertEquals(26, actual);
    }
}