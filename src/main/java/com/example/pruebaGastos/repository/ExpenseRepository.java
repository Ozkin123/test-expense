package com.example.pruebaGastos.repository;

import com.example.pruebaGastos.entity.ExpenseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<ExpenseEntity,String> {
}
