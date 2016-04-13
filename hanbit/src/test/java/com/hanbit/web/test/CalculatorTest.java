package com.hanbit.web.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		// fail("Not yet implemented");
		Calculator c = new Calculator();
		assertEquals(80, c.sum(30, 50));
	}

}
