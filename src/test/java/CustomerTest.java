import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void before() {
        customer = new Customer("Verity", false, 65.8);
    }

    @Test
    public void canGetName() {
        assertEquals("Verity", customer.getName());
    }

    @Test
    public void canSeeHasNotGotLoyaltyCard() {
        assertEquals(false, customer.hasLoyaltyCard());
    }

    @Test
    public void canGetWalletValue() {
        assertEquals(65.8, customer.getWalletValue(), 0.01);
    }

    @Test
    public void canReduceWalletValue() {
        customer.reduceWalletValue(5.8);
        assertEquals(60, customer.getWalletValue(), 0.01);
    }

}
