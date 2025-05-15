package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes a payment made in a sale.
 */
public class Payment {


    private double amountPaid;
    private double totalCost;
    private List<PaymentObserver> paymentObservers= new ArrayList<>(); 

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



    public void notifyObservers() {
        for (PaymentObserver obs : paymentObservers) {
            obs.newPayment(this);
        }
    }

    public void addPaymentObserver(PaymentObserver obs) {
        paymentObservers.add(obs);
    }

    /**
     * Notifies all observers of a
     * @param observers
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }

}
