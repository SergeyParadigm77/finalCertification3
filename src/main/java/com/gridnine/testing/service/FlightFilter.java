package com.gridnine.testing.service;

import com.gridnine.testing.Flight;

// Интерфейс для определения общего поведения фильтра
public interface FlightFilter {
    // Метод, который проверяет, удовлетворяет ли перелет определенному условию
    boolean isValid(Flight flight);
}