package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        ordersOfFurnitures = new HashMap<>();
        // string = new String();
        // integer = new Integer(1);
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        this.ordersOfFurnitures.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        // For loop -> Map, ordersOfFurnitures.entryset()
        // float totalOrderCost = 0.0f;
        // for (Map.Entry<Furniture, Integer> entry : ordersOfFurnitures.entrySet()) {
        // totalOrderCost += this.getTypeCost(entry.getKey());
        // }
        // return totalOrderCost;
        return (float) ordersOfFurnitures.keySet().stream()
                .mapToDouble(e -> this.getTypeCost(e))
                .sum();
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        // return -1;
        if (ordersOfFurnitures.get(type) == null) {
            return 0;
        }
        return ordersOfFurnitures.get(type);
        // return ordersOfFurnitures.get(type) == null ? 0 :
        // ordersOfFurnitures.get(type); // return null
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        // return -1.0f;
        return type.cost() * this.getTypeCount(type);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int totalQuantity = 0;
        for (Map.Entry<Furniture, Integer> entry : ordersOfFurnitures.entrySet()) {
            totalQuantity += this.getTypeCount(entry.getKey());
        }
        return totalQuantity;
        // ordersOfFurnitures.values().stream().mapToInt(Integer::intValue).sum();
    }
}