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

    // was a public String createReceipt but is being changed?
    public void printReceipt(Receipt receipt) {
        //System.out.println("Printing Receipt...");
        System.out.println(receipt.toString()); 
    }
}
