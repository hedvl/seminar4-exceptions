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
    * tests that an item added to a sale is correctly stored in the list of sold items 
    * and verifies both the presence of the item and that only one item has been added.
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
