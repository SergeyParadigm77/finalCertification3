package com.gridnine.testing.service.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.service.FlightFilter;

import java.time.Duration;

public class LongFlightFilter implements FlightFilter {
    // Поле для хранения максимального времени в полете
    private final Duration maxFlightTime;

    // Конструктор, который принимает максимальное время в полете
    public LongFlightFilter(Duration maxFlightTime) {
        this.maxFlightTime = maxFlightTime;
    }

    // Переопределенный метод, который возвращает true, если сумма длительностей всех сегментов перелета не превышает максимального времени в полете
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments().stream()
                .map(segment -> Duration.between(segment.getDepartureDate(), segment.getArrivalDate()))
                .reduce(Duration::plus)
                .orElse(Duration.ZERO)
                .compareTo(maxFlightTime) <= 0;
    }
}