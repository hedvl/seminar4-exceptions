package pos.test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;

/**
 * The tests belonging to the Sale class
 */
public class SaleTest {
    /**
     * Tests that adding an item to a sale works
     */
    @Test
    void testAddItemToSale() {
        Sale sale = new Sale();
        Item item = new Item("abc123", "BigWheel Oatmeal", "Healthy Oats", 29.90, 0.06, 10);
        sale.addItem(item);
        
        assertTrue(sale.getSoldItems().containsKey("abc123"));
        assertEquals(1, sale.getSoldItems().size());
    }

}
