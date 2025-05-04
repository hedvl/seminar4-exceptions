package se.kth.iv1350.pos.view;



import se.kth.iv1350.pos.controller.Controller;

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
        contr.enterItemID("abc123");
        
        contr.enterItemID("def456");
        contr.enterItemID("def456");


        System.out.println("End sale :");
        //System.out.println("Total cost (Including VAT)" + String.format("%2f", contr.getTotalCost()) + "SEK");
        contr.enterAmountPaid(100);
        //System.out.println("Change to give to the customer: " + String.format("%.2f", change));
        


        
    }


}
    


