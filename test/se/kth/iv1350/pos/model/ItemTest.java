package pos.test.se.kth.iv1350.pos.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import se.kth.iv1350.pos.model.Item;

/**
 * The tests for the Item class
 */
public class ItemTest {

    /**
     * Tets that when an item has been created, the information of the getters 
     * gives the right information about the items different qualities of the item.
     */
    @Test
    void testItemCreation() {
        Item item = new Item("abc123", "BigWheel Oatmeal", "Healthy Oats", 29.90, 0.06, 10);
        assertEquals("abc123", item.getItemID());
        assertEquals(29.90, item.getPrice());
        assertEquals(10, item.getQuantity());
    }

}
