package com.example.pruebaGastos.controller;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import com.example.pruebaGastos.dtos.response.ExpenseResponse;
import com.example.pruebaGastos.dtos.response.ExpenseResponseGoogle;
import com.example.pruebaGastos.service.IExpenseService;
import com.example.pruebaGastos.service.IGoogleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ExpenseController {



     private final IGoogleService serviceGoogle;
     private final IExpenseService service;

    @GetMapping("/expense")
    public ResponseEntity<List<ExpenseResponse>> getAllExpense(){
       return new ResponseEntity<>(service.getAllExpense(),HttpStatus.OK);
    }

    @PostMapping(value = "/expense", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ExpenseResponseGoogle> uploadIMG(@RequestPart(value = "file",required = false) MultipartFile file, @RequestPart("dto") ExpenseDto dto) throws IOException {
        String url = serviceGoogle.uploadObject(dto.getName(),file);
        return new ResponseEntity<>(service.addExpense(dto,url),HttpStatus.CREATED);
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
