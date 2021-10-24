package templete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;
    String numFilepath;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = Objects.requireNonNull(getClass().getResource("/numbers.txt")).getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertEquals(calculator.calcSum(this.numFilepath), 10);
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertEquals(calculator.calcMultiply(this.numFilepath), 24);
    }
}