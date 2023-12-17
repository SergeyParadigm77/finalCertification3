package com.gridnine.testing.service.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.service.FlightFilter;

import java.time.LocalDateTime;

public class DepartureBeforeCurrentTimeFilter implements FlightFilter {
    // Поле для хранения текущего момента времени
    private final LocalDateTime currentTime;

    // Конструктор, который принимает текущий момент времени
    public DepartureBeforeCurrentTimeFilter(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    // Переопределенный метод, который возвращает true, если все сегменты перелета имеют дату вылета позже текущего момента времени
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(currentTime));
    }
}