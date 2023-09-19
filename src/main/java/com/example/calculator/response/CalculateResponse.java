package com.example.calculator.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CalculateResponse {
    private BigDecimal result;
}
