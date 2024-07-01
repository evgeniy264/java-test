package org.example;

import org.testng.annotations.Test;

import static org.example.Factorial.factorial;
import static org.testng.Assert.*;

public class FactorialTest2 {

    @Test
    public void testFactorialOfZero() {
        long result = factorial(0);
        assertEquals(1, result);
    }

    @Test
    public void testFactorialOfFive() {
        long result = factorial(5);
        assertTrue(120 == result);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = ".* должно быть неотрицательным")
    public void testFactorialOfMinus() throws IllegalArgumentException {
        long result = factorial(-5);
        fail("Должно быть исключение IllegalArgumentException");
    }
}