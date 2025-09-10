package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
    }

    @Test
    @DisplayName("Check less - equals - greater")
    void testCheckLessOrGreaterEqual() {
        Exercise.checkLessOrGreaterEqual(2,6);
        boolean checkLess = this.outContent.toString().contains(" es menor que ");
        this.outContent.reset();
        assertTrue(checkLess, "n1 is greater or equals than n2");
        Exercise.checkLessOrGreaterEqual(2,2);
        boolean checkEquals = this.outContent.toString().contains(" es mayor o igual que ");
        this.outContent.reset();
        assertTrue(checkEquals, "n1 is not equals than n2");
        Exercise.checkLessOrGreaterEqual(6,2);
        boolean checkGreater = this.outContent.toString().contains(" es mayor o igual que ");
        this.outContent.reset();
        assertTrue(checkGreater, "n1 is not greater than n2");
    }

    @Test
    @DisplayName("Check multiply")
    void testCheckMultiply() {
        Exercise.checkMultiply(6,3);
        boolean checkMulti = this.outContent.toString().contains(" es multiplo de ");
        this.outContent.reset();
        assertTrue(checkMulti, "n1 not multiply of n2");
        Exercise.checkMultiply(3,6);
        boolean checkNotMulti = this.outContent.toString().contains(" no es multiplo de ");
        this.outContent.reset();
        assertTrue(checkNotMulti, "n1 multiply of n2");
    }

    @Test
    @DisplayName("Check positive - zero - negative")
    void testCheckPositiveNegative() {
        Exercise.checkPositiveNegative(1);
        boolean checkPositive = this.outContent.toString().contains(" es positivo.");
        this.outContent.reset();
        assertTrue(checkPositive, "n1 is not positive");
        Exercise.checkPositiveNegative(0);
        boolean checkZero = this.outContent.toString().contains(" es positivo.");
        this.outContent.reset();
        assertTrue(checkZero, "n1 is not zero");
        Exercise.checkPositiveNegative(-1);
        boolean checkNegative = this.outContent.toString().contains(" es negativo.");
        this.outContent.reset();
        assertTrue(checkNegative, "n1 is not negative");
    }
}