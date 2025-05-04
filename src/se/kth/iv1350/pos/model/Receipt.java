package se.kth.iv1350.pos.model;

/**
 * the receipt for a sale.
 */
public class Receipt {
    
    private Payment payment;
    private Sale sale;

    /**
     * The receipt for this instance.
     * @param sale the current sale with the current items.
     * @param payment the payment given for the sale.
     */
    public Receipt(Sale sale, Payment payment) {
        this.sale = sale;
        this.payment = payment;

    }

    /**
     * Builds the receipt with all necessary information about the products and price.
     */
    @Override
    public String toString(){
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("--- RECEIPT --- \n");
        receiptBuilder.append("Time of Sale: ").append(sale.getTimeOfSale()).append("\n");

        for (Item item : sale.getSoldItems().values()) {
            receiptBuilder.append(String.format(
                "%s %d x %.2f = %.2f  SEK \n",
                item.getName(), 
                item.getQuantity(), 
                item.getPrice(), 
                item.getPrice() * item.getQuantity()));
        }
        receiptBuilder.append("\n");
        receiptBuilder.append(String.format("Total Cost: %.2f SEK \n", sale.getTotalCost())).append("\n");
        receiptBuilder.append(String.format("Total VAT: %.2f SEK \n", sale.getTotalVat())).append("\n");


        receiptBuilder.append(String.format("Cash: %.2f SEK\n", payment.getAmountPaid()));
        receiptBuilder.append(String.format("Change: %.2f SEK\n", payment.getChangeAmount()));
        
        receiptBuilder.append("--- END RECEIPT ---");

        return receiptBuilder.toString();
        
    }
}