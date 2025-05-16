package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for inventory database exceptions.
 */
public class InventoryDatabaseExceptionTest {

    /**
     * tests that the message created in this exception is stored correctly.
     */
    @Test
    public void testMessageStoredCorrectly() {
        String msg = "Simulated DB error";
        InventoryDatabaseException exception = new InventoryDatabaseException(msg);

        assertEquals(msg, exception.getMessage(),
            "Exception message should be stored and returned correctly.");
    }
}
