package in.keepgrowing.interviewcodingquestions.datastructures.set.powerset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class PowerSetGeneratorTest {

    private PowerSetGenerator generator;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(emptyList(), 1, "empty list", Set.of(
                        emptySet())),
                Arguments.arguments(singletonList(1), 2, "one-element list", Set.of(
                        emptySet(), Set.of(1))),
                Arguments.arguments(List.of(1, 2), 4, "two-element list", Set.of(
                        emptySet(), Set.of(1), Set.of(2), Set.of(1, 2))),
                Arguments.arguments(List.of(0, 2, 0, 5), 8, "list with duplicates", Set.of(
                        emptySet(), Set.of(0), Set.of(2), Set.of(5), Set.of(0, 2), Set.of(0, 5), Set.of(2, 5),
                        Set.of(0, 2, 5))),
                Arguments.arguments(List.of(0, 2, 3, 5), 16, "four-element list", Set.of(
                        emptySet(), Set.of(0), Set.of(2), Set.of(3), Set.of(5), Set.of(0, 2), Set.of(0, 5), Set.of(0, 3),
                        Set.of(2, 3), Set.of(2, 5), Set.of(3, 5), Set.of(0, 2, 5), Set.of(0, 2, 3), Set.of(0, 3, 5),
                        Set.of(2, 3, 5), Set.of(0, 2, 3, 5)))
        );
    }

    @BeforeEach
    void setUp() {
        generator = new PowerSetGenerator();
    }

    @ParameterizedTest(name = "for {2}")
    @MethodSource(value = "getData")
    void shouldGeneratePowerSetWithRecursiveApproach(List<Integer> numbers, int expectedSize, String testName,
                                                     Set<Set<Integer>> expected) {
        Set<Set<Integer>> actual = generator.generateRecursively(new HashSet<>(numbers));

        assertEquals(expectedSize, actual.size());
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "for {2}")
    @MethodSource(value = "getData")
    void shouldGeneratePowerSetWithBitwiseApproach(List<Integer> numbers, int expectedSize, String testName,
                                                   Set<Set<Integer>> expected) {
        Set<Set<Integer>> actual = generator.withBitwiseApproach(numbers);

        assertEquals(expectedSize, actual.size());
        assertEquals(expected, actual);
    }
}