package com.example.calculator.controller;

import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.CalculateResponse;
import com.example.calculator.response.OpertionInfoResponse;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculate() {
        CalculatorRequest request = new CalculatorRequest();
        BigDecimal expectedResult = new BigDecimal("10");

        when(calculatorService.calculate(request)).thenReturn(new CalculateResponse(expectedResult));

        ResponseEntity<CalculateResponse> responseEntity = calculatorController.calculate(request);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(new CalculateResponse(expectedResult), responseEntity.getBody());
    }

    @Test
    public void testGetAllOperations() {
        List<OpertionInfoResponse> expectedOperations = new ArrayList<>();
        expectedOperations.add(new OpertionInfoResponse(1, "suma"));
        expectedOperations.add(new OpertionInfoResponse(2, "resta"));

        when(calculatorService.getAllOperations()).thenReturn(expectedOperations);

        List<OpertionInfoResponse> operations = calculatorController.getAllOperations();

        assertEquals(expectedOperations, operations);
    }
}
