package by.it_academy.jd2;

import by.it_academy.jd2.dto.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        Assertions.assertEquals(2, calculator.add(1, 1));
    }
}