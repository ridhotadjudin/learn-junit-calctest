package nexsoft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorTDD {
	
	@ParameterizedTest
	@CsvFileSource(resources="data.csv",delimiter=';',numLinesToSkip = 1)
	public void test_multiply_function_by_integer(int a, int b, int expected) {
		//arrange
		Calculator calculator = new Calculator();
		
		//act
		int result = calculator.multiply(a, b);
	
		//assert
		assertEquals(expected, result);
	}
	
}
