package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Receipt;

/**
 * A printer that prints the receipt for a particular sale.
 */
public class Printer {

    /**
     * Prints the receipt
     * @param receipt the receipt that is to be printed
     */
    public void printReceipt(Receipt receipt) {
        System.out.println("Printing Receipt...");
        System.out.println(receipt.toString());
    }
}
