package com.krishna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OddEvenTest {

    @Test
    void tenShouldBeEven() {
        assertTrue(OddEven.isEven(10));
    }

    @Test
    void sevenShouldBeOdd() {
        assertFalse(OddEven.isEven(7));
    }

    @Test
    void shouldReturnEvenMessage() {
        assertEquals(
                "10 is an even number.",
                OddEven.checkNumber(10)
        );
    }
}