package com.example.calculator.service.impl;

import com.example.calculator.exceptions.CustomExceptionHandler;
import com.example.calculator.request.CalculatorRequest;
import com.example.calculator.response.OpertionInfoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplTest {

	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalculateAdd() {
		CalculatorRequest request = new CalculatorRequest(BigDecimal.valueOf(2),BigDecimal.valueOf(3), 1);

		BigDecimal result = calculatorService.calculate(request);

		assertEquals(new BigDecimal("5"), result);
	}

	@Test
	public void testCalculateSubtract() {
		CalculatorRequest request = new CalculatorRequest(BigDecimal.valueOf(10),BigDecimal.valueOf(4), 2);

		BigDecimal result = calculatorService.calculate(request);

		assertEquals(new BigDecimal("6"), result);
	}

	@Test
	public void testCalculateInvalidOperation() {
		CalculatorRequest request = new CalculatorRequest(BigDecimal.valueOf(2),BigDecimal.valueOf(3), 3);
		// Invalid operation type

		assertThrows(CustomExceptionHandler.class, () -> {
			calculatorService.calculate(request);
		});
	}

	@Test
	public void testGetAllOperations() {
		List<OpertionInfoResponse> operations = calculatorService.getAllOperations();

		assertEquals(2, operations.size());

		OpertionInfoResponse operation1 = operations.get(0);
		assertEquals(1, operation1.getValue());
		assertEquals("suma", operation1.getName());

		OpertionInfoResponse operation2 = operations.get(1);
		assertEquals(2, operation2.getValue());
		assertEquals("resta", operation2.getName());
	}
}



