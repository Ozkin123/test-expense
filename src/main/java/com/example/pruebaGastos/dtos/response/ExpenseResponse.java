package com.example.pruebaGastos.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponse(String description, BigDecimal value, LocalDate date, LocalDate modifyDate) {
}
