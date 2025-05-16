
package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for the exception thrown when an item cannot be found.
 */
public class ItemNotFoundExceptionTest {

    /**
     * Tests that the error message includes the item ID of the invalid item
     */
    @Test
    public void testGetMessageIncludesItemID() {
        String testID = "invalidID";
        ItemNotFoundException exception = new ItemNotFoundException(testID);

        assertTrue(exception.getMessage().contains(testID),
            "Exception message should include the invalid item ID.");
    }

    /**
     * Tests that getItemID returns the correct id
     */
    @Test
    public void testGetItemIDReturnsCorrectID() {
        String testID = "testItem123";
        ItemNotFoundException exception = new ItemNotFoundException(testID);

        assertEquals(testID, exception.getItemID(),
            "getItemID() should return the correct item ID.");
    }

}
