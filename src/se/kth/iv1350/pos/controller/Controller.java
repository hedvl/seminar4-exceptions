package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.TotalRevenueView;
import se.kth.iv1350.pos.integration.*;

import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.integration.InventoryDatabaseException;
import se.kth.iv1350.pos.integration.ErrorLogger;


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
     * @return returns the itemDTO representing the item
     * @throws ItemNotFoundException of the item is not found in the inventory
     * @throws OperationFailedException if an unexpected error occurs like a database failure.
     */
    public ItemDTO enterItemID(String itemID) throws ItemNotFoundException, 
    OperationFailedException {
        try {
        Item item = inventory.fetchItem(itemID);
        
        item.setQuantity(1); 
        
        
        sale.addItem(item);
        return item.itemToItemDTO();
        } catch (InventoryDatabaseException e) 
        {
            throw new OperationFailedException("Could not retrieve item", e);
            
            }

    }



    /**
     * Completes the sale by processing the payment, updating systems
     * with the payment and printing the receipt.
     * @param amountPaid the amount that has been paid.
     */
    public Payment enterAmountPaid(double amountPaid) {
        payment = new Payment(amountPaid, sale.getTotalCost());

        updateExternalSystems(payment);

        

        if (hasValidItems()) {
            createAndPrintReceipt(sale, payment);
            
        }

        return payment; 
        
        
        
        
    }

    private void createAndPrintReceipt (Sale sale, Payment payment) {
        receipt = new Receipt(sale, payment);
        printer.printReceipt(receipt);
    }

    private void updateExternalSystems(Payment payment) {

        register.updateRegister(payment.getAmountPaid());
        inventory.updateInventory(sale);
        accounting.updateAccounting(payment);
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

        return payment.getChangeAmount();
    }

    public boolean hasValidItems() {
        return sale.hasValidItems();
    }

}