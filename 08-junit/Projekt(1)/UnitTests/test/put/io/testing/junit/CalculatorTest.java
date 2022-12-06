package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach //COMMENT
    void setUp(){
        calculator = new Calculator();
    }
    @Test
    void testAdd(){
        int res = calculator.add(1, 3);
        assert (res == 4);
        res = calculator.add(10, 15);
        assert (res == 25);
    }
    @Test
    void testMultiply(){

        int res = calculator.multiply(1, 3);
        assert (res == 3);
        res = calculator.multiply(10, 15);
        assert (res == 150);
    }

    @Test
    void testAddPositiveNumbers(){
        IllegalArgumentException  thrown = Assertions.assertThrows(IllegalArgumentException .class, () -> {
            int res = calculator.addPositiveNumbers(-2,3);
        });

    }

}