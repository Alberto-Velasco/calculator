package com.example.calculator.controller;

import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.CalculateResponse;
import com.example.calculator.response.OpertionInfoResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponse> calculate(@RequestBody CalculatorRequest request) {
        return ResponseEntity.ok(calculatorService.calculate(request));
    }

    // Endpoint para obtener todas las operaciones disponibles
    @GetMapping("/operations")
    public List<OpertionInfoResponse> getAllOperations() {
        return calculatorService.getAllOperations();
    }
}

