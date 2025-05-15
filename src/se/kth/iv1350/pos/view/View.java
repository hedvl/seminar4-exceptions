package se.kth.iv1350.pos.view;



import se.kth.iv1350.pos.controller.Controller;

import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.integration.InventoryDatabaseException;
import se.kth.iv1350.pos.integration.ErrorLogger;
/**
 * This is a placeholder for the real view. Only contains hard conded calls to the controller.
 */

public class View {
    private Controller contr;
    private ErrorLogger logger = new ErrorLogger();


    /**
     * Creates a new instance with the specific controller contr.
     * @param contr the controller which is used for calls to all layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates fake sales in order to show how the program works as well as
     * tests different types of errors.
     */
    public void runFakeExecution() {

        simulateSale(new String[]{"abc123","invalidID","failDB"}, 100);
        simulateSale(new String[]{"def456"}, 50);

    }

    private void simulateSale(String[] itemIDs, int amountPaid) {
        contr.startSale();
        System.out.println("A new sale has been started: ");


        for(String itemID : itemIDs) {
            scanAndAddItem(itemID);
        }

        System.out.println("END SALE");
        contr.enterAmountPaid(amountPaid);
        showChange();


    }


    /**
     * Scans the item and adds it to the current sale while also checking for relevant exceptions.
     * Prints item and sale details.
     * @param itemID the ID of the item being scanned.
     */
    public void scanAndAddItem(String itemID) {
        try {
            ItemDTO item = contr.enterItemID(itemID);
        
            
            System.out.println("Add 1 item with item id " + item.getItemID() + ":");
            System.out.println("Item ID: " + item.getItemID());
            System.out.println("Item name: " + item.getName());
            System.out.println("Item cost: " + item.getPrice());
            System.out.println("VAT: " + String.format("%.0f%%", item.getVat() * 100));
            System.out.println("Item Description: " + item.getItemDescription());
            System.out.println("Total Cost (Including VAT): " + String.format("%.2f", contr.getTotalCost()) + "SEK");
            System.out.println("Total VAT: " + String.format("%.2f", contr.getTotalVat()) + "SEK");
        } catch (ItemNotFoundException e) {
            System.out.println("Inventory error:" + e.getMessage());
            logger.logException(e);
        } catch (InventoryDatabaseException e) {
            System.out.println("DATABASE ERROR: " + e.getMessage());
            logger.logException(e);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            logger.logException(e);
        }
        

        }

    

    private void showChange() {
        System.out.println("Change to give to customer: " + String.format("%.2f", contr.getChangeAmount()) + " SEK");
    }



}
    


