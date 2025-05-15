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
   
    private final TotalRevenueView totalRevenueView = new TotalRevenueView();
    private final TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
    
    private void attachObserversToPayment(Payment payment) {
        payment.addPaymentObserver(totalRevenueView);
        payment.addPaymentObserver(totalRevenueFileOutput);
    
    }
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
     */
    public ItemDTO enterItemID(String itemID) throws ItemNotFoundException, 
    InventoryDatabaseException {
        try {
        Item item = inventory.fetchItem(itemID);
        
            item.setQuantity(1); 
        
        
        sale.addItem(item);
        return item.itemToItemDTO();
        } catch (ItemNotFoundException e) {
            System.out.println("INVENTORY ERROR" + e.getMessage());
            throw e;
        } catch (InventoryDatabaseException e) {
            System.out.println("DATABASE ERROR: " + e.getMessage());
            throw e;
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

        attachObserversToPayment(payment);
        payment.notifyObservers();

        createndPrintReceipt(sale, payment);
        
        return payment; 
        
    }

    private void createndPrintReceipt (Sale sale, Payment payment) {
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

}