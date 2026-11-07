package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    Inventory inventory;
    Recipe coffee = new Recipe();
    Recipe test = new Recipe();

    @BeforeEach
    void setup() {
        inventory = new Inventory();

        coffee.setName("coffee");
        coffee.setPrice(5);
        coffee.setAmtChocolate(0);
        coffee.setAmtMilk(1);
        coffee.setAmtSugar(2);
        coffee.setAmtCoffee(5);

        test.setName("test");
        test.setPrice(5);
        test.setAmtChocolate(5);
        test.setAmtMilk(5);
        test.setAmtSugar(5);
        test.setAmtCoffee(5);
    
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }

    @Test
    void testEnoughIngredients() {
        assertTrue(inventory.enoughIngredients(coffee));
        inventory.setCoffee(0);
        assertFalse(inventory.enoughIngredients(coffee));

        inventory.setCoffee(5);
        assertTrue(inventory.enoughIngredients(test));
        inventory.setMilk(5);
        assertTrue(inventory.enoughIngredients(test));
        inventory.setChocolate(5);
        assertTrue(inventory.enoughIngredients(test));
        inventory.setSugar(5);
        assertTrue(inventory.enoughIngredients(test));
    }

    @Test
    void testEnoughIngredientsAll() {
        /* removed for Task 4 - Step 2
        inventory.setCoffee(0);
        assertFalse(inventory.enoughIngredients(test));
        inventory.setCoffee(5);
        inventory.setMilk(0);
        assertFalse(inventory.enoughIngredients(test));
        inventory.setMilk(5);
        inventory.setSugar(0);
        assertFalse(inventory.enoughIngredients(test));
        inventory.setSugar(5);
        inventory.setChocolate(0);
        assertFalse(inventory.enoughIngredients(test));
        inventory.setChocolate(5);
        */
    }

    @Test
    void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @Test
    void testSetChocolate() {
        inventory.setChocolate(20);
        assertEquals(20, inventory.getChocolate());
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
        inventory.setChocolate(-1);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    void testSetCoffee() {
        inventory.setCoffee(20);
        assertEquals(20, inventory.getCoffee());
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee());
        inventory.setCoffee(-1);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    void testSetMilk() {
        inventory.setMilk(20);
        assertEquals(20, inventory.getMilk());
        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk());
        inventory.setMilk(-1);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    void testSetSugar() {
        inventory.setSugar(20);
        assertEquals(20, inventory.getSugar());
        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar());
        inventory.setSugar(-1);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    void testToString() {
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", inventory.toString());
    }
    
}
