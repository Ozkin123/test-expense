package com.example.pruebaGastos.service;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import com.example.pruebaGastos.entity.response.ExpenseResponse;
import com.example.pruebaGastos.entity.response.ExpenseResponseGoogle;

import java.util.List;

public interface IExpenseService {

    ExpenseResponseGoogle addExpense(ExpenseDto dto, String url);
    List<ExpenseResponse> getAllExpense();


}
