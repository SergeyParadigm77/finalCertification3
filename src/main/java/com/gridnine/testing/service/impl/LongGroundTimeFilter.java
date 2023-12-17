package com.gridnine.testing.service.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.time.Duration;
import java.util.List;

// Класс для фильтрации перелетов, где общее время, проведенное на земле, превышает два часа
public class LongGroundTimeFilter implements FlightFilter {
    // Поле для хранения максимального времени на земле
    private final Duration maxGroundTime;

    // Конструктор, который принимает максимальное время на земле
    public LongGroundTimeFilter(Duration maxGroundTime) {
        this.maxGroundTime = maxGroundTime;
    }

    // Переопределенный метод, который возвращает true, если время на земле между каждыми двумя сегментами перелета не превышает максимального времени на земле
    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            Duration groundTime = Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
            if (groundTime.compareTo(maxGroundTime) > 0) {
                return false;
            }
        }
        return true;
    }
}