package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddUsingMock() {
        Calculator calc = mock(Calculator.class);

        when(calc.add(10, 20)).thenReturn(30);

        assertEquals(30, calc.add(10, 20));
        verify(calc).add(10, 20);
    }

    @Test
    public void testVoidMethod() {
        Calculator calc = mock(Calculator.class);

        doNothing().when(calc).display(anyString());

        calc.display("Mockito Rocks!");
        verify(calc).display("Mockito Rocks!");
    }
}
