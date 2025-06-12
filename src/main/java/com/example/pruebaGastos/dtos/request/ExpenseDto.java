package com.example.pruebaGastos.dtos.request;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private String name;
    private String description;
    private BigDecimal value;
}
