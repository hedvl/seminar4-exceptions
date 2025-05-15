package se.kth.iv1350.pos.integration;

/**
 * Thrown when the inventory database is not available or fails.
 */
public class InventoryDatabaseException extends Exception {
    /**
     * The inventory database exception.
     * @param message the error message.
     */
    public InventoryDatabaseException(String message) {
        super(message);
    }
}
