package com.unittest.store;

public class Customer {

    public boolean purchase(Store store, Product product, int quantity) {
        if(!store.hasEnoughInventory(product, quantity)) {
            return false;
        }
        store.removeFromInventory(product, quantity);
        return true;
    }
}
