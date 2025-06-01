package pos.test.se.kth.iv1350.pos.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.model.*;
/**
 * tests the controller
 */
public class ControllerTest {
    private Controller controller;

    /**
     * sets up controller and starts the sale.
     */
    @BeforeEach
    void setUp() {
        controller = new Controller();
        controller.startSale();
    }

    /**
     * tests that the cost of the sale is zero before any items have been added
     */
    @Test
    void testStartOfSaleTotalCost() {
        double totalCost = controller.getTotalCost();
        assertEquals(0.00, totalCost, "Total cost should be 0.00 before any items have been added");
    }
    /**
     * tests that when a valid item ID has been added, the getItemID does not return null
     */
    @Test
    void testEnterValidItemID() throws Exception {
        ItemDTO item = controller.enterItemID("abc123");
        assertNotNull(item.getItemID(), "The returned item should have the corect ID");
        
    }
    /**
     * tests that when an invalid item ID is entered, an exception is thrown
     */
    @Test
    void testEnterInvalidItemIDThrowsException() {
        assertThrows(ItemNotFoundException.class, () -> 
        {
            controller.enterItemID("fgeri3");
        });

        
    }
    /**
     * tests that when the InventoryDatabaseException is thrown, an OperationFailedException
     * will be thrown.
     */
    @Test 
    void testDatabaseFailureThrowsOperationFailedException() {
        assertThrows(OperationFailedException.class, () -> 
        {
            controller.enterItemID("failDB");
        });

    }
    /**
     * tests that the saleDTO is not null whne an item has been added and that it contains
     * the correct item.
     */
    @Test
    void testGetSaleInfoReturnsCorrectDTO() {
        controller.enterItemID("abc123");
        SaleDTO saleDTO = controller.getSaleDetails();
        assertNotNull(saleDTO, "SaleDTO should not be null.");
        assertTrue(saleDTO.getSoldItems().containsKey("abc123"), "SaleDTO should contain the added item");
    }
}   
