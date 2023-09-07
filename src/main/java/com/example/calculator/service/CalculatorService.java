package com.example.calculator.service;

import com.example.calculator.request.CalculatorRequest;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal add(CalculatorRequest request);

    BigDecimal subtract(CalculatorRequest request);
}
