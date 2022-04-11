package in.keepgrowing.interviewcodingquestions.algorithms.sorting.withcomparators;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class JavaComparatorDemo {

    private static final Comparator<FlightItinerary> COMPARATOR_BY_DURATION_BY_STOPS_BY_CARRIER_ASC =
            ((Comparator<FlightItinerary>) JavaComparatorDemo::compareFlightDuration)
                    .thenComparingInt(FlightItinerary::connections)
                    .thenComparing(FlightItinerary::carrier, Comparator.nullsLast(naturalOrder()));

    private static int compareFlightDuration(FlightItinerary first, FlightItinerary second) {
        var firstDuration = Duration.between(first.arrival(), first.departure());
        var secondDuration = Duration.between(first.arrival(), second.departure());

        return firstDuration.compareTo(secondDuration);
    }

    public List<Long> sortFlights(List<FlightItinerary> itineraries) {
        return itineraries.stream()
                .sorted(COMPARATOR_BY_DURATION_BY_STOPS_BY_CARRIER_ASC)
                .map(FlightItinerary::bookingId)
                .toList();
    }
}
