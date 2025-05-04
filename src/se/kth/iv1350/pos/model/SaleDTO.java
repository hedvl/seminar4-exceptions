package se.kth.iv1350.pos.model;


import java.util.*;

/**
 * the saleDTO for the sale.
 */
public class SaleDTO {

    private double totalCost;
    private double totalVat;
    private final Map<String, ItemDTO> soldItems;
    private final String timeOfSale;

    /**
     * creates a SaleDTO for this instance. 
     * @param totalCost the total cost attributed to the sale
     * @param totalVat the total VAT rate of the sale
     * @param soldItems the list of sold items
     * @param timeOfSale the time the sale took place
     */
    public SaleDTO(double totalCost, double totalVat, Map<String, ItemDTO> soldItems, 
    String timeOfSale) {
        this.totalCost = totalCost;
        this.totalVat = totalVat;
        this.soldItems = Collections.unmodifiableMap(soldItems);
        this.timeOfSale = timeOfSale;
    }

    




    /**
     * gets total cost
     * @return the total cost of the sale
     */
    public double getTotalCost() { 
        return totalCost; 
    }
    /**
     * 
     * @return the total vat rate of the sale
     */
    public double getTotalVat() { 
        return totalVat; 
    }
    /**
     * 
     * @return all of the sold items in the sale
     */
    public Map<String, ItemDTO> getSoldItems() { 
        return soldItems; 
    }
    /**
     * 
     * @return the time the sale was made
     */
    public String getTimeOfSale() { 
        return timeOfSale; 
    }


}

