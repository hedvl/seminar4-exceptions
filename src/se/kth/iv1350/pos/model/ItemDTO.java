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
