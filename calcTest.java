package SWENG_ASS1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calcTest {

    @Test
    void testIsOperator(){
        assertTrue(calc.isOperator("+"));
        assertTrue(calc.isOperator("-"));
        assertTrue(calc.isOperator("*"));
        assertFalse(calc.isOperator("9"));
        assertFalse(calc.isOperator("5.7"));
        assertFalse(calc.isOperator("!"));
    }

    @Test
    void testIsNumber(){
        assertFalse(calc.isNumber("-"));
        assertTrue(calc.isNumber("6"));
    }

    @Test
    void testCheckValidInfix(){
        assertTrue(calc.checkValidInfix("7+8"));
        assertFalse(calc.checkValidInfix("*&"));

    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}