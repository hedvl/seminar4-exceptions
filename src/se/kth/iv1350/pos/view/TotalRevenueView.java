package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.PaymentObserver;

/*
 * In your Process Sale program, use the Observer pattern to implement a new function-
ality, namely to show the sum of the costs for all sales made since the program started.
This total income shall be handled by two new classes. The first, TotalRevenueView,
shall be placed in the view and show the total income on the user interface, for ex-
ample by printing to System.out. 
 */

/**
 * 
 */
public class TotalRevenueView implements PaymentObserver {

    private double totalRevenue;

    @Override
    public void newPayment(Payment payment) {
        totalRevenue += payment.getAmountPaid() - payment.getChangeAmount();
        printTotalCostsForAllSales();
    }

    private void printTotalCostsForAllSales() {

        System.out.println("Total revenue:" + String.format("%.2f", totalRevenue) + "SEK");
    }
                      
}
