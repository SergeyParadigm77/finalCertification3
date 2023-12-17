package com.gridnine.testing.service.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.service.FlightFilter;

// Класс для фильтрации перелетов с датой прилета раньше даты вылета
public class ArrivalBeforeDepartureFilter implements FlightFilter {
    // Переопределенный метод, который возвращает true, если все сегменты перелета имеют дату прилета позже даты вылета
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }
}