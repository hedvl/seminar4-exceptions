package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

/**
 * This is the application's controller. 
 */
public class Controller {
    private Sale sale;
    private Inventory inventory;
    private Printer printer = new Printer();
    private Register register = new Register();
    private Accounting accounting = new Accounting();

    /**
     * Creates an instance of the controller with an inventory.
     */
    public Controller() {
        this.inventory = new Inventory();
    }

    /**
     * This method starts a new sale. This method must be called first in order for a sale to start.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Finds the scanned item in the inventory and adds it to the sale if it exists.
     * @param itemID the ID of the item that has been scanned and is to be bought.
     * @return returns the item
     */
    public Item enterItemID(String itemID) {
        Item item = inventory.fetchItem(itemID);
        if (item != null) {
            System.out.println("Add 1 item with item id " + itemID + ":");
            sale.addItem(item);
            return item;
        }         
        System.out.println("Invalid item ID, " + itemID + " is not in the system.");
        return null;
    }

    /**
     * Completes the sale by processing the payment, updating register, inventory & accounting systems
     * with the payment and printing the receipt.
     * @param amountPaid
     */
    public void enterAmountPaid(double amountPaid) {
        Payment payment = new Payment(amountPaid, sale.getTotalCost());
        
        register.updateRegister(amountPaid);
        inventory.updateInventory(sale);
        accounting.updateAccounting(payment);

        Receipt receipt = new Receipt(sale, payment);
        printer.printReceipt(receipt);
        System.out.println("Change to give to customer: " + String.format("%.2f", payment.getChangeAmount()) + " SEK");
    }

    /**
     * Returns a DTO representation of the current sale
     * Useful for the view or printing receipt.
     * @return The current sale as a SaleDTO.
     */
    public SaleDTO getSaleDetails() {
        return sale.getSaleDTO();  
    }

    /**
     * Getter of the total cost.
     * @return the total cost of the particular sale
     */
    public double getTotalCost() {
        return sale.getTotalCost();
    }

}