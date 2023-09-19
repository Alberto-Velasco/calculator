package com.example.calculator.service;

import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.CalculateResponse;
import com.example.calculator.response.OpertionInfoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface CalculatorService {

    List<OpertionInfoResponse> getAllOperations();
    CalculateResponse calculate(CalculatorRequest request);

    BigDecimal add(CalculatorRequest request);

    BigDecimal subtract(CalculatorRequest request);
}
