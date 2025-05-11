package se.kth.iv1350.pos.view;



import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.SaleDTO;

/**
 * This is a placeholder for the real view. Only contains hard conded calls to the controller.
 */

public class View {
    private Controller contr;


    /**
     * Creates a new instance with the specific controller contr.
     * @param contr the controller which is used for calls to all layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Starts a fake sale. Gives the system the two fake item ID's.
     */
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started: ");
        addItem("abc123");
        
        addItem("def456");
        addItem("def456");


        System.out.println("End sale :");
        
        contr.enterAmountPaid(100);
        //printReceipt();
        showChange();
        
    }

    /**
     * Adds the item to the sale and prints the information, unless the item is null, in 
     * which case an error messaage is returned.
     * @param itemID the ID of the item being scanned.
     */
    public void addItem(String itemID) {
        ItemDTO item = contr.enterItemID(itemID);
        if (item != null) {
            
            System.out.println("Add 1 item with item id " + item.getItemID() + ":");
            System.out.println("Item ID: " + item.getItemID());
            System.out.println("Item name: " + item.getName());
            System.out.println("Item cost: " + item.getPrice());
            System.out.println("VAT: " + String.format("%.0f%%", item.getVat() * 100));
            System.out.println("Item Description: " + item.getItemDescription());
            System.out.println("Total Cost (Including VAT): " + String.format("%.2f", contr.getTotalCost()) + "SEK");
            System.out.println("Total VAT: " + String.format("%.2f", contr.getTotalVat()) + "SEK");
        }
        else {
            System.out.println("Invalid item ID, " + itemID + " is not in the system.");
        }
    }

    private void showChange() {
        System.out.println("Change to give to customer: " + String.format("%.2f", contr.getChangeAmount()) + " SEK");
    }

    /* 
    private void printReceipt () {
        System.out.println(contr.getReceiptString());
    }

*/

}
    


