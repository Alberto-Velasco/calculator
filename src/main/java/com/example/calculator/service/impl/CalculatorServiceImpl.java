package com.example.calculator.service.impl;

import com.example.calculator.config.TracerConfig;
import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.CalculateResponse;
import com.example.calculator.response.OpertionInfoResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private TracerConfig tracerConfig;

    public CalculateResponse calculate(@RequestBody CalculatorRequest request) {
        BigDecimal result;
        switch (request.getOperationType()){
            case 1:
                result = add(request);
                break;
            case 2:
                result = subtract(request);
                break;
            default:
                throw new IllegalArgumentException("Tipo de operación no válido, valor recibido:" +
                        " " + request.getOperationType());
        }
        tracerConfig.getTracerImpl().trace("Tipo de operación: " + request.getOperationType() + " , " +
                "Primer operando: " +request.getOperand1() + " , " +
                "Segundo operando: " +request.getOperand2() + " , " +
                "Resultado: " + result);

        return (new CalculateResponse(result));
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
