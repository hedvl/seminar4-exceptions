package se.kth.iv1350.pos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * a sale made by a customer, paid with one single payment.
 */

public class Sale {
    private LocalDateTime timeOfSale;
    private double totalCost;
    private double totalVat;
    private final Map<String, Item> soldItems = new LinkedHashMap<>();
    
    private final String timeOfSaleFormatted;
    /**
     * Creates a new instance of  a sale and saves the time the sale has been made.
     */
    public Sale() {
        this.timeOfSale = LocalDateTime.now();
    DateTimeFormatter formatForTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    this.timeOfSaleFormatted = timeOfSale.format(formatForTime);
    }

    /**
     * Getter of the time of sale.
     * @return returns the formatted date and time.
     */
    public String getTimeOfSale() {
        return timeOfSaleFormatted;
    }



    /**
     * Adds a new item to the sale and finds the calculated total price for it (with VAT) as well
     * as the total VAT Rate. Prints the information about the item.
     * @param item The item that is added to the sale.
     */
    public void addItem(Item item) {
        Item existingItem = soldItems.get(item.getItemID());
        if (existingItem != null) {
            existingItem.increaseQuantity(1);
        }
        else {
            soldItems.put(item.getItemID(), item);
        }

        calculateTotal();


   
    }
    private void calculateTotal() {
        totalCost = 0;
        totalVat = 0;
        for (Item i : soldItems.values()) {
            totalCost += i.totalPriceWithVat();
            totalVat += i.totalVatAmount();
        }
    }
    /**
     * 
     * @return the total cost that should be paid.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * 
     * @return the total VAT in SEK
     */
    public double getTotalVat() {
        return totalVat;
    }

    /**
     * 
     * @return all items in the sale.
     */
    public Map<String, Item> getSoldItems() {
        return soldItems;
    }


    /**
     * Calculates how much money the customer should get back in change.
     * @param amountPaid  the full amount the customer has paid, which must be equal to 
     * or more than the total cost.
     * @return the total amount that should be given back in change.
     */
    public double calculateChange(double amountPaid) {
        return amountPaid - totalCost;
        
    }

    /**
     * The saleDTO that belongs to this sale.
     * @return the saleDTO with all the current information from the sale
     */
    public SaleDTO getSaleDTO() {
        Map<String, ItemDTO> itemDTOs = new LinkedHashMap<>();
        for (Item item : soldItems.values()) {
            ItemDTO dto = new ItemDTO(
                item.getItemID(),
                item.getName(),
                item.getItemDescription(),
                item.getPrice(),
                item.getVat(),
                item.getQuantity()
            );
            itemDTOs.put(item.getItemID(), dto);
        }
        return new SaleDTO(totalCost, totalVat, itemDTOs, timeOfSaleFormatted);
    }


    public boolean hasValidItems() {
        return !soldItems.isEmpty();
    }
    
}