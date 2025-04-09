package com.example.pruebaGastos.entity;



import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("expenses")
public class ExpenseEntity {

    @Id
    private String id;
    private String description;
    private BigDecimal value;
    private LocalDate date;
    private LocalDate modifyDate;
}
