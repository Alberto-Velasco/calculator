package com.example.calculator;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.exceptions.CustomExceptionHandler;
import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.service.impl.CalculatorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorServiceImpl calculatorService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController)
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Test
    public void testAdd() throws Exception {
        CalculatorRequest request = new CalculatorRequest();
        request.setOperand1(BigDecimal.valueOf(5));
        request.setOperand2(BigDecimal.valueOf(3));
        BigDecimal expectedResult = BigDecimal.valueOf(8);

        when(calculatorService.add(request)).thenReturn(expectedResult);

        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult.toString()));
    }

    @Test
    public void testSubtract() throws Exception {
        CalculatorRequest request = new CalculatorRequest();
        request.setOperand1(BigDecimal.valueOf(8));
        request.setOperand2(BigDecimal.valueOf(3));
        BigDecimal expectedResult = BigDecimal.valueOf(5);

        when(calculatorService.subtract(request)).thenReturn(expectedResult);

        mockMvc.perform(post("/api/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult.toString()));
    }
}
