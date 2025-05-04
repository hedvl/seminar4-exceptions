package se.kth.iv1350.pos.integration;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.model.Payment;
public class Accounting {

    private List<Payment> payments;

    /**
     * initializes the list of payments
     */
    public Accounting() {
        payments = new ArrayList<>();
    }
    
    /**
     * update the accounting system with the payment
     * @param payment the payment that has been made
     */
    public void updateAccounting(Payment payment) {
        payments.add(payment);

    }


}
