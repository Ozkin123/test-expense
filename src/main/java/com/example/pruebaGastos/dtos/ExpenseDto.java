package com.example.pruebaGastos.dtos;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private String description;
    private BigDecimal value;
}
