package com.example.calculator;

import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@Mock
	private CalculatorRequest calculatorRequest;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdd() {
		when(calculatorRequest.getOperand1()).thenReturn(BigDecimal.valueOf(5));
		when(calculatorRequest.getOperand2()).thenReturn(BigDecimal.valueOf(3));

		BigDecimal result = calculatorService.add(calculatorRequest);

		assertEquals(BigDecimal.valueOf(8), result);
	}

	@Test
	public void testSubtract() {
		when(calculatorRequest.getOperand1()).thenReturn(BigDecimal.valueOf(8));
		when(calculatorRequest.getOperand2()).thenReturn(BigDecimal.valueOf(3));

		BigDecimal result = calculatorService.subtract(calculatorRequest);

		assertEquals(BigDecimal.valueOf(5), result);
	}
}


