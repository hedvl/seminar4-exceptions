package se.kth.iv1350.pos.model;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */
public class TotalRevenueFileOutput implements PaymentObserver {


    private double totalRevenue;
    private  PrintWriter logStream;

    /**
     * 
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(
                        new FileWriter("totalRevenue.txt", true));   
        } catch (IOException ioe) {
            System.out.println("Cannot log");
            ioe.printStackTrace();
        }
    }

    /**
     * creates a new payment to be added to the total revenue
     * @param payment the payment to be added.
     */
    public void newPayment(Payment payment) {
        totalRevenue += payment.getTotalCost();
        log("Total Revenue For this Instance: " + String.format("%.2f",totalRevenue) + "SEK");
    }

    private void log (String message) {
        logStream.println(message);

        logStream.flush();
    }

}
