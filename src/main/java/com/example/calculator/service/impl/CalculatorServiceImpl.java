package com.example.calculator.service.impl;

import com.example.calculator.exceptions.CustomExceptionHandler;
import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.OpertionInfoResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public BigDecimal calculate(@RequestBody CalculatorRequest request) {
        BigDecimal result;
        switch (request.getOperationType()){
            case 1:
                result = add(request);
                break;
            case 2:
                result = subtract(request);
                break;
            default:
                throw new CustomExceptionHandler("Unexpected value: " + request.getOperationType());
        }
        return (result);
    }

    public List<OpertionInfoResponse> getAllOperations() {
        List<OpertionInfoResponse> operations = new ArrayList<>();
        operations.add(new OpertionInfoResponse(1, "suma"));
        operations.add(new OpertionInfoResponse(2, "resta"));
        return operations;
    }

    public BigDecimal add(CalculatorRequest request) {
        return request.getOperand1().add(request.getOperand2());
    }

    public BigDecimal subtract(CalculatorRequest request) {
        return request.getOperand1().subtract(request.getOperand2());
    }

    // Otros métodos para operaciones adicionales
}
