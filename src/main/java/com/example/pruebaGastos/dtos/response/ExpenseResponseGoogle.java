package com.example.pruebaGastos.dtos.response;

import java.math.BigDecimal;

public record ExpenseResponseGoogle(String url, String description, BigDecimal value, String name) {
}

