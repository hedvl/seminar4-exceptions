package se.kth.iv1350.pos.model;


/**
 * The Item class saves the Item and info about it. As well as defining how to
 * calculate the VAT rate.
 */
public class Item {
    private String itemID;
    private String name;
    private String itemDescription;
    private double price;
    private double vat;
    private int quantity;
    
    /**
     * Defines an item and its qualities.
     * @param itemID the item ID
     * @param name the name of the item
     * @param itemDescription describes the item
     * @param price how much the item costs
     * @param vat the VAT rate of the item
     * @param quantity how many of the particlar item is being bought
     */
    public Item (String itemID, String name, String itemDescription, double price, double vat, double quantity) {
        this.itemID = itemID;
        this.name = name;
        this.itemDescription = itemDescription;
        this.price = price;
        this.vat = vat;
        this.quantity = (int) quantity;
    }

    /**
     * 
     * @return the Item ID of the item.
     */
    public String getItemID() {
        return itemID;
        }
    /**
     * 
     * @return the name of the item.
     */
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

    public ItemDTO itemToItemDTO() {
        return new ItemDTO(itemID, name, itemDescription, price, vat, quantity);
    }

    /**
     * increases the quantity of items with a particular item ID.
     * @param amount the amount of that item that are to be sold.
     */
    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    /**
     * calculates the total price for the item(s), taking into consideration
     * whether there are more than one of the particular item.
     * @return the total price (with VAT) in SEK.
     */
    public double totalPriceWithVat() {
        return price * quantity * (1 + vat);
    }
    /**
     * Calculates total VAT amount for the item
     * @return the total VAT amount in SEK
     */
    public double totalVatAmount() {
        return price * quantity * vat;
    }
    /**
     * set the quantity of the item to what it should be. 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
