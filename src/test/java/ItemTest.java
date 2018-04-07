import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item item;

    @Before
    public void before() {
        item = new Item("toothpaste", 3.5);
    }

    @Test
    public void canGetName() {
        assertEquals("toothpaste", item.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(3.5, item.getPrice(), 0.01);
    }

    @Test
    public void canGetIsNotOnBOGOF() {
        assertEquals(false, item.isOnBOGOF());
    }

    @Test
    public void canChangeToBeOnBOGOF() {
        item.setOnBOGOF(true);
        assertEquals(true, item.isOnBOGOF());
    }
}
