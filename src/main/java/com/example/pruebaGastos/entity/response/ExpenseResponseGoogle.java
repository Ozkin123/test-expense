package com.example.pruebaGastos.entity.response;

import java.math.BigDecimal;

public record ExpenseResponseGoogle(String url, String description, BigDecimal value, String name) {
}

