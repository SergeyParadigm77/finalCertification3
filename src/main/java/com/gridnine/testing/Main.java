package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.impl.*;

public class Main {
    public static void main(String[] args) {
        // Получаем тестовый набор перелетов
        List<Flight> flights = FlightBuilder.createFlights();

        // Создаем массив фильтров
        FlightFilter[] filters = {
                new DepartureBeforeCurrentTimeFilter(LocalDateTime.now()),
                new ArrivalBeforeDepartureFilter(),
                new LongGroundTimeFilter(Duration.ofHours(2)),
                new LongFlightFilter(Duration.ofHours(5)),
                new MaxSegmentsFilter(2)
        };

        // Для каждого фильтра применяем его к тестовому набору и выводим результат в консоль
        for (FlightFilter filter : filters) {
            List<Flight> validFlights = flights.stream()
                    .filter(filter::isValid)
                    .toList();

            System.out.println("Valid flights for " + filter.getClass().getSimpleName() + ":");
            validFlights.forEach(System.out::println);
        }
    }
}
