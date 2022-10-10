package SWENG_ASS1;

import org.junit.jupiter.api.Test;

import static SWENG_ASS1.calc.calculate;
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

    @Test
    void testCalculate() throws Exception {
        assertEquals("10", calculate("5+5"));
        assertEquals("10", calculate("5*2"));
        assertEquals("30", calculate("50-20"));
        assertEquals("6", calculate("2+2+2"));
        assertEquals("6", calculate("2*4-2)"));
        assertEquals("0", calculate("10-5*2"));



    }
    @org.junit.jupiter.api.Test
    void main() {
    }


}