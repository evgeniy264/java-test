package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Factorial.*;

class FactorialTest {
    @DisplayName("Проверка с 0")
    @Test
    public void testFactorialOfZero() {
        long result = factorial(0);
        Assertions.assertEquals(1, result);
    }

    @DisplayName("Проверка с 5")
    @Test
    public void testFactorialOfFive() {
        long result = factorial(5);
        Assertions.assertTrue(120 == result);
    }

    @DisplayName("Проверка с отрицательным значением")
    @Test
    public void testFactorialOfMinus() throws IllegalArgumentException {
        try {
            long result = factorial(-5);
            Assertions.fail("Должно быть исключение IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            Assertions.assertNotEquals("", thrown.getMessage());
        }
    }
}