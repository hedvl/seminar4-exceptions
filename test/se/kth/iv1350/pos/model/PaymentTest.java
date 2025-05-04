package pos.test.se.kth.iv1350.pos.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    /**
     * tests that the amount that has been paid matches the input
     */
    @Test
    void testGetAmountPaid() {
        double expectedAmountPaid = 200.0;
        Payment payment = new Payment(expectedAmountPaid, 150.0);
        
        assertEquals(expectedAmountPaid, payment.getAmountPaid(), "Amount paid should match input.");
    }
    /**
     * tests that the amount of change is calculated correctly and gives the right amount.
     */
    @Test
    void testGetChangeAmount() {
        double amountPaid = 200.0;
        double totalCost = 150.0;
        double expectedChange = 50.0;

        Payment payment = new Payment(amountPaid, totalCost);

        assertEquals(expectedChange, payment.getChangeAmount(), "Change should be correctly calculated.");
    }


    /** 
     * tests that in the case the exact price of the sale is paid, the change should be zero.
     */
    @Test
    void testGetChangeAmountExactPayment() {
        Payment payment = new Payment(150.0, 150.0);
        assertEquals(0.0, payment.getChangeAmount(), "Change should be zero when payment equals cost.");
    }

}