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
        sale.addItem(item2); 
    }

    @Test
    void testUpdateInventoryReducesStock() {
        Inventory inventory = new Inventory();
        Item originalItem = inventory.fetchItem("abc123");
        int originalQuantity = originalItem.getQuantity();
    
        Sale sale = new Sale();
        sale.addItem(new Item("abc123", "BigWheel Oatmeal", 
            "BigWheel Oatleam 500ml, whole grain oats, high fiber, gluten free", 
            29.90, 0.06, 1));
    
        inventory.updateInventory(sale);
    
        Item updated = inventory.getItems().get("abc123");
    
        assertTrue(updated == null); 
    }

    @Test
    public void testUpdateInventoryRemovesOutOfStock() {
        inventory.updateInventory(sale);
        Map<String, Item> updatedItems = inventory.getItems();

        
        assertFalse(updatedItems.containsKey("abc123"));
        assertFalse(updatedItems.containsKey("def456"));
    }
}