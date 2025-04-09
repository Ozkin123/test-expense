package com.example.pruebaGastos.controller;

import com.example.pruebaGastos.dtos.ExpenseDto;
import com.example.pruebaGastos.service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class ExpenseController {

      private final IExpenseService service;

//    @GetMapping("/expense")
//    public List<ExpenseEntity> getEntity(){
//       return expenseRepository.findAll();
//    }
//
     @PostMapping("/expense")
    public ResponseEntity<ExpenseDto> upExpense(@RequestBody ExpenseDto dto){
       return new ResponseEntity<>(service.addExpense(dto), HttpStatus.CREATED);
    }
//
//    @PutMapping("/expense/{id}")
//    public void udpateExpense(@PathVariable String id, @RequestParam int value){
//        Optional foo = expenseRepository.findById(id);
//        ExpenseEntity entity1 = (ExpenseEntity) foo.get();
//        entity1.setValue(new BigDecimal(value));
//        entity1.setModifyDate(LocalDate.now());
//        expenseRepository.save(entity1);
//    }
//
//    @DeleteMapping("expense/{id}")
//    public void deleteExpense(@PathVariable String id){
//        expenseRepository.deleteById(id);
//    }
}
