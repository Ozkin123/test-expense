package com.example.pruebaGastos.service;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import com.example.pruebaGastos.dtos.response.ExpenseResponse;
import com.example.pruebaGastos.entity.ExpenseEntity;
import com.example.pruebaGastos.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ExpenseResponse> getAllExpense() {

       List<ExpenseEntity> list= repository.findAll();
       List<ExpenseResponse> responses=list.stream().map(
               entity ->new  ExpenseResponse(
                         entity.getDescription(),
                         entity.getValue(),
                         entity.getDate(),
                         entity.getModifyDate())
       ).collect(Collectors.toList());
       return responses;
    }
}
