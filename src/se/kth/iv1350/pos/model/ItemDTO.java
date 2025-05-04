package se.kth.iv1350.pos.model;

/**
 * The ItemDTO class for the Item.
 */
public class ItemDTO {
    private String itemID;
    private String name;
    private String itemDescription;
    private double price;
    private double vat;
    private int quantity;

    /**
     * The ItemDTO for a particular sale with all its qualities.
     * @param itemID the ID of the item
     * @param name the name of the item
     * @param itemDescription the description
     * @param price the price of the item
     * @param vat the VAT rate of the item
     * @param quantity the quantity of the item being bought
     */
    public ItemDTO(String itemID, String name, String itemDescription, 
    double price, double vat, double quantity) {
        this.itemID = itemID;
        this.name = name;
        this.itemDescription = itemDescription;
        this.price = price;
        this.vat = vat;
        this.quantity = (int) quantity;
    }

    /**
     * 
     * @return
     */
    public String getItemID() {
        return itemID;
        }
    public String getName() {
        return name;
        }
    public String getItemDescription() {
        return itemDescription;
    }
    public double getPrice() {
        return price; 
    }
    public double getVat() {
        return vat;
    }
    public int getQuantity() {
        return quantity;
    }
}
