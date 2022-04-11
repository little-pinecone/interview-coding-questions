package in.keepgrowing.interviewcodingquestions.algorithms.sorting.withcomparators;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

public record FlightItinerary(
        Long bookingId,
        @Nullable
        String carrier,
        int connections,
        LocalDateTime arrival,
        LocalDateTime departure) {
}
