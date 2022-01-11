package com.unittest.store;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private Map<Product, Integer> inventory = new HashMap<>();

    public boolean hasEnoughInventory(Product product, int quantity) {
        return inventory.getOrDefault(product, 0) >= quantity;
    }

    public void removeFromInventory(Product product, int quantity) {
        if (!hasEnoughInventory(product, quantity)) {
            throw new IllegalStateException("Not Enough Inventory");
        }
        inventory.put(product, inventory.get(product) - quantity);
    }
}
