import org.junit.Test;
import static org.junit.Assert.*;

public class test {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals("Sum should be 5", 5, 2 + 3);

        // Assert true
        assertTrue("5 is greater than 3", 5 > 3);

        // Assert false
        assertFalse("5 is not less than 3", 5 < 3);

        // Assert null
        Object obj1 = null;
        assertNull("Object should be null", obj1);

        // Assert not null
        Object obj2 = new Object();
        assertNotNull("Object should not be null", obj2);
    }
}
