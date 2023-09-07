package com.example.calculator.service.impl;

import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public BigDecimal add(CalculatorRequest request) {
        return request.getOperand1().add(request.getOperand2());
    }

    public BigDecimal subtract(CalculatorRequest request) {
        return request.getOperand1().subtract(request.getOperand2());
    }

    // Otros métodos para operaciones adicionales
}
