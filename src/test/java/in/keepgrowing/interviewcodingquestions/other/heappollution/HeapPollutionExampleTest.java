package in.keepgrowing.interviewcodingquestions.other.heappollution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HeapPollutionExampleTest {

    private HeapPollutionExample example;

    @BeforeEach
    void setUp() {
        example = new HeapPollutionExample();
    }

    @Test
    void shouldRunDemo() {
        assertThrows(ClassCastException.class, () -> example.runDemo());
    }
}