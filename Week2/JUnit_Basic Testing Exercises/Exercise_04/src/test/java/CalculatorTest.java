import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Setup: runs before each test
        calculator = new Calculator();
        System.out.println("Setup complete.");
    }

    @After
    public void tearDown() {
        // Teardown: runs after each test
        calculator = null;
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals("Addition should return 8", 8, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals("Subtraction should return 6", 6, result);
    }
}
