package com.example.pruebaGastos.service;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import com.example.pruebaGastos.dtos.response.ExpenseResponse;

import java.util.List;

public interface IExpenseService {

    ExpenseDto addExpense(ExpenseDto dto);
    List<ExpenseResponse> getAllExpense();


}
