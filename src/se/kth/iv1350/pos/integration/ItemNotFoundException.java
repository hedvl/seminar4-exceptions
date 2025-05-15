package se.kth.iv1350.pos.integration;

/**
 * Thrown when an item with the specified ID is not found in the inventory.
 */
public class ItemNotFoundException extends Exception {
    private final String itemID;

    /**
     * An error message for when an entered item ID cannot be found in the inventory.
     * @param itemID the itemID that can't be found.
     */
    public ItemNotFoundException(String itemID) {
        super("Item with ID '" + itemID + "' was not found in the inventory.");
        this.itemID = itemID;
    }

    /**
     * getter of item id
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }
}
