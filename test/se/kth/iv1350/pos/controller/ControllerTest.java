package pos.test.se.kth.iv1350.pos.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;



import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.model.*;
public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
        controller.startSale();
    }

    @Test
    void testStartOfSaleTotalCost() {
        double totalCost = controller.getTotalCost();
        assertEquals(0.00, totalCost, "Total cost should be 0.00 before any items have been added");
    }
    @Test
    void testEnterValidItemID() {
        Item item = controller.enterItemID("abc123");
        assertNotNull(item.getItemID(), "The returned item should have the corect ID");
        
    }
    @Test
    void testenterInvalidItemID() {
        Item item = controller.enterItemID("saw445");
        assertNull(item, "The returned item should be null");
    }
    
    @Test
    void testGetSaleInfoReturnsCorrectDTO() {
        controller.enterItemID("abc123");
        SaleDTO saleDTO = controller.getSaleDetails();
        assertNotNull(saleDTO, "SaleDTO should not be null.");
        assertTrue(saleDTO.getSoldItems().containsKey("abc123"), "SaleDTO should contain the added item");
    }
}   
