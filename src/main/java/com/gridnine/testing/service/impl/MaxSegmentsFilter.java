package com.gridnine.testing.service.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.service.FlightFilter;

// Класс для фильтрации перелетов, где количество сегментов превышает два
public class MaxSegmentsFilter implements FlightFilter {
    // Поле для хранения максимального количества сегментов
    private final int maxSegments;

    // Конструктор, который принимает максимальное количество сегментов
    public MaxSegmentsFilter(int maxSegments) {
        this.maxSegments = maxSegments;
    }

    // Переопределенный метод, который возвращает true, если количество сегментов перелета не превышает максимального количества сегментов
    @Override
    public boolean isValid(Flight flight) {
        return flight.getSegments().size() <= maxSegments;
    }
}