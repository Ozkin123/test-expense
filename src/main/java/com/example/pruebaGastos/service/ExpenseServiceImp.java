package com.example.pruebaGastos.service;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import com.example.pruebaGastos.dtos.response.ExpenseResponse;
import com.example.pruebaGastos.entity.ExpenseEntity;
import com.example.pruebaGastos.dtos.response.ExpenseResponseGoogle;
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
    public ExpenseResponseGoogle addExpense(ExpenseDto dto,String url) {
        ExpenseEntity entity = new ExpenseEntity();
        ExpenseResponseGoogle response = new ExpenseResponseGoogle(url, dto.getDescription(),dto.getValue(), dto.getName());
        entity.setUrl(url);
        entity.setDescription(dto.getDescription());
        entity.setValue(dto.getValue());
        entity.setDate(LocalDate.now());
        repository.insert(entity);
        return response ;
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
