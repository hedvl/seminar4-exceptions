package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Receipt;

/**
 * A printer that makes the receipt for a particular sale.
 */
public class Printer {

    /**
     * creates a string version of the receipt. 
     * @param receipt the receipt that is to be printed, as a string
     */
    public String createReceipt(Receipt receipt) {
        //System.out.println("Printing Receipt...");
        return receipt.toString();
    }
}
