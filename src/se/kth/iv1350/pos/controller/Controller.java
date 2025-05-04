package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.view.View;

/**
 * This is the application's controller. 
 */
public class Controller {
    private Sale sale;
    private Inventory inventory;
    private Printer printer = new Printer();
    private Register register = new Register();
    private Accounting accounting = new Accounting();
    private Receipt receipt;
    private Payment payment; 
   
    
  
    /**
     * Creates an instance of the controller with an inventory and a view.
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
            sale.addItem(item);
            return item; 
        }
        return null;
    }


    /**
     * Completes the sale by processing the payment, updating register, inventory & accounting systems
     * with the payment and printing the receipt.
     * @param amountPaid
     */
    public Payment enterAmountPaid(double amountPaid) {
        payment = new Payment(amountPaid, sale.getTotalCost());

        register.updateRegister(amountPaid);
        inventory.updateInventory(sale);
        accounting.updateAccounting(payment);

        receipt = new Receipt(sale, payment);
        printer.createReceipt(receipt);
        
        return payment; 
        
    }

    /**
     * Returns a DTO representation of the current sale
     * useful for the view or printing receipt.
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

    /**
     * Getter of VAT rate
     * @return the total VAT rate of the sale
     */
    public double getTotalVat() {
        return sale.getTotalVat();
    }

    public double getChangeAmount() {
        if (payment == null) {
            System.out.println("Error: Payment is null. Can't calculate change.");
            return 0.0; 
        }
        return payment.getChangeAmount();
    }

    /**
     * Generates and returns the receipt string.
     * @return A formatted receipt string to be printed by the View.
     */
    public String getReceiptString() {
        return printer.createReceipt(receipt);
    }
}