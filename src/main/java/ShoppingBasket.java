import com.sun.deploy.panel.ITreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private double totalBasketValue;
    private Customer basketUser;

    public ShoppingBasket(Customer basketUser) {
        this.basketUser = basketUser;
        this.items = new ArrayList<>();
        this.totalBasketValue = 0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotalBasketValue() {
        return totalBasketValue;
    }

    public Customer getBasketUser() {
        return basketUser;
    }

    public void emptyItems() {
        this.items.clear();
    }

    public void setNewBasketUser(Customer basketUser) {
        this.basketUser = basketUser;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double calculateBaseBasketValue() {
        double baseValue = 0;
        for (Item item : items) {
            baseValue += item.getPrice();
        }
        return baseValue;
    }

    public HashMap<Item,Integer> countOfItemsInBasket() {
        HashMap<Item,Integer> itemCount = new HashMap<>();
        for (Item item : items) {
            itemCount.put(item, Collections.frequency(items, item));
        }
        return itemCount;
    }

    public double calculateBasketValuePostBOGOFs() {
        double totalValue = 0;
        HashMap<Item,Integer> itemCount = countOfItemsInBasket();
        for (HashMap.Entry<Item,Integer> entry : itemCount.entrySet()) {
            if (entry.getKey().isOnBOGOF() == true) {
                totalValue += entry.getKey().getPrice() * (entry.getValue()/2 +  entry.getValue()%2);
            } else {
                totalValue += entry.getKey().getPrice() * entry.getValue();
            }
        }
        return totalValue;
    }

    public double calculateTotalBasketValue() {
        double totalValue = calculateBasketValuePostBOGOFs();
        if (totalValue > 20) {
            totalValue = totalValue * 0.9;
        }
        if (this.basketUser.hasLoyaltyCard() == true) {
            totalValue = totalValue * 0.98;
        }
        return totalValue;
    }


}
