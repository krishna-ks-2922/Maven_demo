package com.krishna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSignTest {

    @Test
    void shouldIdentifyPositiveNumber() {
        assertEquals(
                "10 is positive.",
                NumberSign.checkSign(10)
        );
    }

    @Test
    void shouldIdentifyNegativeNumber() {
        assertEquals(
                "-5 is negative.",
                NumberSign.checkSign(-5)
        );
    }

    @Test
    void shouldIdentifyZero() {
        assertEquals(
                "The number is zero.",
                NumberSign.checkSign(0)
        );
    }
}