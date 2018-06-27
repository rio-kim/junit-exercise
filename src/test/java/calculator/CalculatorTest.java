package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	int a;
	int b;
	Calculator cal;

	@Before
	public void setup() {
		a = 20;
		b = 10;
		cal = new Calculator();
	}

	@Test
	public void test_add() {
		int result = cal.add(a, b);
		assertEquals(30, result);
	}

	@Test
	public void test_subtract() {
		int result = cal.subtract(a, b);
		assertTrue(result == 10);
	}

	@Test
	public void test_multiply() {
		int result = cal.multiply(a, b);
		assertEquals(200, result);
	}

	@Test
	public void test_divide() {
		int result = cal.divide(a, b);
		assertEquals(2, result);
		assertNotEquals(3, result);
	}

}
