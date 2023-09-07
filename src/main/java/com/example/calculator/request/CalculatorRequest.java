package com.example.calculator.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculatorRequest {
    private BigDecimal operand1;
    private BigDecimal operand2;
}
