package com.hanbit.web.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator c = new Calculator();
	@Test
	public void testSum() {
		assertEquals(7, c.sum(3, 7));
	}

}
