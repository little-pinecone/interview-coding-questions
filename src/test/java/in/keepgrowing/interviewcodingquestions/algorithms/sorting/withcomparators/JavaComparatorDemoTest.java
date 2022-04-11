package in.keepgrowing.interviewcodingquestions.algorithms.sorting.withcomparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.*;
import java.util.List;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaComparatorDemoTest {

    private static final LocalDateTime TIME = LocalDateTime.of(2000, Month.APRIL, 1, 12, 0);
    private static final Clock CLOCK = Clock.fixed(TIME.toInstant(ZoneOffset.UTC), ZoneId.of("UTC"));
    private static final LocalDateTime NOW = LocalDateTime.now(CLOCK);

    private JavaComparatorDemo demo;

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new FlightItinerary(1L, "A", 2, NOW, NOW.plus(1, DAYS)),
                                new FlightItinerary(2L, "B", 1, NOW, NOW.plus(1, DAYS))
                        ),
                        List.of(2L, 1L),
                        "same durations, different connections"
                ),
                Arguments.arguments(
                        List.of(
                                new FlightItinerary(1L, "A", 1, NOW, NOW.plus(1, DAYS)),
                                new FlightItinerary(2L, "B", 1, NOW, NOW.plus(2, DAYS))
                        ),
                        List.of(1L, 2L),
                        "same connections, different durations"
                ),
                Arguments.arguments(
                        List.of(
                                new FlightItinerary(1L, "A", 1, NOW, NOW.plus(1, DAYS)),
                                new FlightItinerary(2L, "B", 1, NOW, NOW.plus(1, DAYS))
                        ),
                        List.of(1L, 2L),
                        "identical flights, different carriers"
                ),
                Arguments.arguments(
                        List.of(
                                new FlightItinerary(1L, "A", 3, NOW, NOW.plus(3, DAYS)),
                                new FlightItinerary(2L, "B", 2, NOW, NOW.plus(3, DAYS)),
                                new FlightItinerary(3L, "C", 1, NOW, NOW.plus(1, DAYS)),
                                new FlightItinerary(4L, "D", 1, NOW, NOW.plus(2, DAYS)),
                                new FlightItinerary(5L, "E", 1, NOW, NOW.plus(1, DAYS))
                        ),
                        List.of(3L, 5L, 4L, 2L, 1L),
                        "different durations, connections, carriers"
                ),
                Arguments.arguments(
                        List.of(
                                new FlightItinerary(1L, null, 1, NOW, NOW.plus(1, DAYS)),
                                new FlightItinerary(2L, "B", 1, NOW, NOW.plus(1, DAYS))
                        ),
                        List.of(2L, 1L),
                        "carrier name is null"
                )
        );
    }

    @BeforeEach
    void setUp() {
        demo = new JavaComparatorDemo();
    }

    @ParameterizedTest(name = "when {2}")
    @MethodSource(value = "getData")
    void shouldSortFlights(List<FlightItinerary> flights, List<Long> expected, String testName) {
        List<Long> actual = demo.sortFlights(flights);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSameFlightWhenOnlyOneGiven() {
        var flight = new FlightItinerary(1L, "A", 2, NOW, NOW.plus(1, DAYS));
        List<Long> actual = demo.sortFlights(List.of(flight));

        assertEquals(1, actual.size());
        assertEquals(List.of(1L), actual);
    }

    @Test
    void shouldReturnEmptyListWhenEmptyFlights() {
        List<Long> actual = demo.sortFlights(emptyList());

        assertTrue(actual.isEmpty());
    }
}