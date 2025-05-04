package se.kth.iv1350.pos.model;


/**
 * Describes a payment made in a sale.
 */
public class Payment {


    private double amountPaid;
    private double totalCost;


    /**
     * Creates a payment for the particular instance.
     * @param amountPaid the amount that the customer has paid.
     * @param totalCost the total cost that should be paid.
     */
    public Payment(double amountPaid, double totalCost) {
        this.amountPaid= amountPaid;
        this.totalCost = totalCost;

    }

    /**
     * 
     * @return the amount that should be paid.
     */
    public double getAmountPaid() {
        return amountPaid;
    }


    /**
     * 
     * @return the amount of change the customer should get back.
     */
    public double getChangeAmount() {
        return amountPaid - totalCost;
    }
}
