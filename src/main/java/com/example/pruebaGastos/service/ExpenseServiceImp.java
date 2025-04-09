package com.example.pruebaGastos.service;

import com.example.pruebaGastos.dtos.ExpenseDto;
import com.example.pruebaGastos.entity.ExpenseEntity;
import com.example.pruebaGastos.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ExpenseServiceImp implements IExpenseService{

    private final ExpenseRepository repository;

    @Override
    public ExpenseDto addExpense(ExpenseDto dto) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setDescription(dto.getDescription());
        entity.setValue(dto.getValue());
        entity.setDate(LocalDate.now());
        repository.insert(entity);
        return dto;
    }
}
