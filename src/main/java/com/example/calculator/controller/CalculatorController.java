package com.example.calculator.controller;

import com.example.calculator.exceptions.CustomExceptionHandler;
import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestControllerAdvice
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public ResponseEntity<BigDecimal> add(@RequestBody CalculatorRequest request) {
        BigDecimal result = calculatorService.add(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/subtract")
    public ResponseEntity<BigDecimal> subtract(@RequestBody CalculatorRequest request) {
        BigDecimal result = calculatorService.subtract(request);
        return ResponseEntity.ok(result);
    }

    // Otros endpoints para operaciones adicionales

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<String> handleInvalidOperation(CustomExceptionHandler ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.getMessage());
    }
}

