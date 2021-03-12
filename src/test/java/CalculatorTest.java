import calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void sqrt(){
        assertEquals("Square Root of a positive number ", 2, calculator.root(4), DELTA);
        assertEquals("Square Root of a positive number", 3, calculator.root(9), DELTA);
    }
//
//    @Test
//    public void addingFalsePositive(){
//        assertNotEquals("Adding two integer numbers for False Positive", 6, calculator.root(36), DELTA);
//        assertNotEquals("Adding two double numbers for False Positive", 7, calculator.root(49), DELTA);
//    }

    @Test
    public void factorial(){
        assertEquals("Factorial of the number ", 120, calculator.fact(5), DELTA);
        assertEquals("Factorial of the number ", 1, calculator.fact(0), DELTA);
    }

//    @Test
//    public void falseFact(){
//        assertNotEquals("Subtracting two integer numbers for False Positive", 0, calculator.fact(2), DELTA);
//        assertNotEquals("Subtracting two double numbers for False Positive", -7.3, calculator.fact(2.1, 3.2), DELTA);
//    }

    @Test
    public void logarithms(){
        assertEquals("Logs of positive number with result in integers", 1, calculator.logar(10), DELTA);
        assertEquals("Log of positive number with result in decimals", 2.69897, calculator.logar(500), DELTA);
    }

//    @Test
//    public void multiplyingFalsePositive(){
//        assertNotEquals("Multiplying two integer numbers for False Positive", 6, calculator.multiply(2, 2), DELTA);
//        assertNotEquals("Multiplying two double numbers for False Positive", 7.3, calculator.multiply(2.1, 3.2), DELTA);
//    }

    @Test
    public void dividingTruePositive(){
        assertEquals("", 4, calculator.power(2, 2), DELTA);
        assertEquals("", 1, calculator.power(0, 0), DELTA);
        assertEquals("", 10, calculator.power(10,1), DELTA);
        assertEquals("", 1, calculator.power(-1, 0), DELTA);
    }

//    @Test
//    public void dividingFalsePositive(){
//        assertNotEquals("Dividing two integer numbers for True Positive", 1, calculator.divide(2.3, 1.3), DELTA);
//        assertNotEquals("Dividing two double numbers for True Positive", 0, calculator.divide(0, 0), DELTA);
//        assertNotEquals("Dividing two double numbers for True Positive", 1, calculator.divide(1, 0), DELTA);
//        assertNotEquals("Dividing two double numbers for True Positive", -1, calculator.divide(-1, 0), DELTA);
//    }
}
