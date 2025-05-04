package pos.test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.*;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    /**
     * Tests that the receipt output contains the correct information when making a sale with
     * a specific item and specific amount.
     */
    @Test
    void testReceiptToStringContainsTheCorrectInfo() {
       
        Item item = new Item("ghi789", "Peanut Butter", "200 ml Peanut Butter Jar", 30.0, 0.06, 1);
        Sale sale = new Sale();
        sale.addItem(item);
        Payment payment = new Payment(50.0, sale.getTotalCost());

        Receipt receipt = new Receipt(sale, payment);

        

        String receiptOutput = receipt.toString();

        
        assertTrue(receiptOutput.contains("Peanut Butter"), "Receipt should contain item name.");
        assertTrue(receiptOutput.contains("Total Cost"), "Receipt should contain total cost.");
        assertTrue(receiptOutput.contains("Cash: 50,00 SEK"), "Receipt should show correct cash.");
        assertTrue(receiptOutput.contains("Change"), "Receipt should contain change.");

    }
    
}