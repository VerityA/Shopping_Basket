import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Customer customer1;
    Customer customer2;
    Item item1;
    Item item2;

    @Before
    public void before() {
        customer1 = new Customer("Verity", false, 65.8);
        customer2 = new Customer("David", true, 73.2);
        shoppingBasket = new ShoppingBasket(customer1);
        item1 = new Item("toothpaste", 3.5);
        item2 = new Item("duvet", 39.5);
    }

    @Test
    public void canGetItems() {
        assertEquals(0, shoppingBasket.getItems().size());
    }

    @Test
    public void canGetBasketUser() {
        assertEquals(customer1, shoppingBasket.getBasketUser());
    }

    @Test
    public void canGetTotalValue() {
        assertEquals(0, shoppingBasket.getTotalBasketValue(), 0.01);
    }

    @Test
    public void canAddItemToBasket() {
        shoppingBasket.addItem(item1);
        assertEquals(1, shoppingBasket.getItems().size());
    }

    @Test
    public void canEmptyItems() {
        shoppingBasket.addItem(item1);
        shoppingBasket.emptyItems();
        assertEquals(0, shoppingBasket.getItems().size());
    }

    @Test
    public void canSetNewBasketUser() {
        shoppingBasket.setNewBasketUser(customer2);
        assertEquals(customer2, shoppingBasket.getBasketUser());
    }

    @Test
    public void canCalculateBaseBasketValue() {
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        assertEquals(43, shoppingBasket.calculateBaseBasketValue(), 0.01);
    }

    @Test
    public void canCountNumberOfItemsInBasket() {
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        System.out.println(shoppingBasket.countOfItemsInBasket());
    }

    @Test
    public void canCalculateBasketValuePostBOGOFs() {
        item1.setOnBOGOF(true);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        assertEquals(46.5 , shoppingBasket.calculateBasketValuePostBOGOFs(),0.01);
    }

    @Test
    public void canCalculateBasketValuePostBOGOFsV2() {
        item1.setOnBOGOF(true);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        assertEquals(43.0 , shoppingBasket.calculateBasketValuePostBOGOFs(),0.01);
    }

    @Test
    public void canCalculateBasketValuePostBOGOFOver£20() {
        item1.setOnBOGOF(true);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        assertEquals(41.85 , shoppingBasket.calculateTotalBasketValue(),0.01);
    }

    @Test
    public void canCalculateBasketValuePostBOGOFOver£20CustHasLoyaltyCard() {
        shoppingBasket.setNewBasketUser(customer2);
        item1.setOnBOGOF(true);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item1);
        shoppingBasket.addItem(item2);
        assertEquals(41.01 , shoppingBasket.calculateTotalBasketValue(),0.01);
    }

}
