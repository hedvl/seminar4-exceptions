package se.kth.iv1350.pos.integration;

import java.util.Map;
import java.util.HashMap;



import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;

/**
 * This class represents the inventory from which the controller can get
 * the items.
 */
public class Inventory {

    private final Map<String, Item> items = new HashMap<>();

    /**
     * Declares and populates the inventory with items. 
     */
    public Inventory() {
        items.put("abc123", new Item("abc123", "BigWheel Oatmeal", 
        "BigWheel Oatmeal 500ml, whole grain oats, high fiber, gluten free", 29.90, 0.06, 5));
        items.put("def456", new Item("def456","YouGOGo Bluebuerry",
        "YouGoGo Blueberry 240g, low sugar, blueberry flavor yoghurt", 14.90, 0.06, 5));
    }
    /**
     * fetches the item information belonging to the itemID from the Item class.
     * @param itemID the ID of the scanned item.
     * @return either returns a new Item or null if the item ID is invalid.
     */
    public Item fetchItem(String itemID) throws ItemNotFoundException, InventoryDatabaseException {
        if ("failDB".equals(itemID)) {
            throw new InventoryDatabaseException("Simulated database connection failure.");
        }
        Item item = items.get(itemID);
        if (item != null) {
            return new Item(item.getItemID(), item.getName(), item.getItemDescription(), 
            item.getPrice(), item.getVat(), item.getQuantity());
            
        }
        throw new ItemNotFoundException(itemID);
    }

    /**
     * getter of items
     * @return the items
     */
    public Map<String, Item> getItems() {
        return new HashMap<>(items);
    }

    /**
     * updates the inventory with bought items, removing the item type from the inventory
     * if there are no more in stock.
     * @param sale the sale in which the particular items were bought.
     */
    public void updateInventory(Sale sale) {
    for (Map.Entry<String, Item> soldEntry : sale.getSoldItems().entrySet()) {
        String itemID = soldEntry.getKey();
        Item soldItem = soldEntry.getValue();

        Item inventoryItem = items.get(itemID);
        if (inventoryItem != null) {
            int newQuantity = inventoryItem.getQuantity() - soldItem.getQuantity();
            if (newQuantity <= 0) {
                items.remove(itemID); 
            } else {
                inventoryItem = new Item(
                    inventoryItem.getItemID(),
                    inventoryItem.getName(),
                    inventoryItem.getItemDescription(),
                    inventoryItem.getPrice(),
                    inventoryItem.getVat(),
                    newQuantity
                );
                items.put(itemID, inventoryItem); 
            }
        }
    }
}

}
