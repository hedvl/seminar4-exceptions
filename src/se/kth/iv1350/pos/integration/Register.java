package se.kth.iv1350.pos.integration;



public class Register {

    private double amountInRegister;
    private double initialBalance = 0;

    public Register() {
        this.amountInRegister = initialBalance;
    }

    /**
     * Updates the amount of money shown to be present in the register with the amount 
     * the customer has paid.
     * @param amountPaid the amount that has been paid by the customer.
     */
    public void updateRegister(double amountPaid) {
        amountInRegister += amountPaid;
        // System.out.println("Register has been updated with " + amountPaid + " SEK");
    }



}
