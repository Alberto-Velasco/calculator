package com.example.calculator.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorRequest {
    private BigDecimal operand1;
    private BigDecimal operand2;
    /* Indica el tipo de operación que se quiere realizar (1 = suma, 2 = resta) */
    private int operationType;
}
