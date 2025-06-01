package pos.test.se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Sale sale;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        sale = new Sale();

        Item item1 = inventory.fetchItem("abc123");
        Item item2 = inventory.fetchItem("def456");
        sale.addItem(item1); 
        sale.addItem(item2); 

    }

    /**
     * creates a new inventory with one item and then adds it to a sale.
     * tests that when an item quantity in the inventory is zero, after updating th einventory
     * with the sale, the item does not exist anymore in the inventory.
     */
    @Test
    void testUpdateInventoryReducesStock() {
        Inventory inventory = new Inventory();
        Item originalItem = inventory.fetchItem("abc123");
        int originalQuantity = originalItem.getQuantity();
    
        Sale sale = new Sale();
        sale.addItem(new Item("abc123", "BigWheel Oatmeal", 
            "BigWheel Oatmeal 500ml, whole grain oats, high fiber, gluten free", 
            29.90, 0.06, 1));
    
        inventory.updateInventory(sale);
    
        Item updated = inventory.getItems().get("abc123");
    
        assertTrue(updated == null); 
    }


    /**
     * verifies that an item is not in the inventory anymore if the quantity of it is zero after updating,
     * and that if the quantity is larger than zero after updating, it should still be in the inventory.
     */
    @Test
    public void testUpdateInventoryRemovesOutOfStock() {
        inventory.updateInventory(sale);
        Map<String, Item> updatedItems = inventory.getItems();

        
        assertFalse(updatedItems.containsKey("abc123"),"abc123 should be removed after selling all stock");
        assertTrue(updatedItems.containsKey("def456","def456 should remain in inventory "));
    }


    @Test
    void testItemNotFoundExceptionIsThrown() {
        assertThrows(ItemNotFoundException.class, () -> 
        {
            inventory.fetchItem("invalidID");
        });
    }

    @Test
    void testInventoryDatabaseExceptionIsThrown() {
        assertThrows(InventoryDatabaseException.class, () -> 
        {
            inventory.fetchItem("failDB");
        });
    }
}