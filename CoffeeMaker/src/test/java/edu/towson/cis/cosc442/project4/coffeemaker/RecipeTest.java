package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    CoffeeMaker coffeeMaker;

    Recipe coffee = new Recipe();
    Recipe test = new Recipe();

    @BeforeEach
    void setup() {
        coffee.setName("coffee");
        coffee.setPrice(5);
        coffee.setAmtChocolate(0);
        coffee.setAmtMilk(1);
        coffee.setAmtSugar(2);
        coffee.setAmtCoffee(5);

        coffeeMaker = new CoffeeMaker(); // empty coffee maker
    }

    @AfterEach
    void tearDown() {
        coffeeMaker = null;
    }

    @Test
    void testEquals() {
        assertTrue(coffee.equals(coffee));
        assertFalse(coffee.equals(test));
    }

    @Test
    void testGetAmtChocolate() {
        assertEquals(0, coffee.getAmtChocolate());
    }

    @Test
    void testGetAmtCoffee() {
        assertEquals(5, coffee.getAmtCoffee());
    }

    @Test
    void testGetAmtMilk() {
        assertEquals(1, coffee.getAmtMilk());
    }

    @Test
    void testGetAmtSugar() {
        assertEquals(2, coffee.getAmtSugar());
    }

    @Test
    void testGetName() {
        coffee.setName("coffee");
        coffee.setPrice(3);
        assertEquals("coffee", coffee.getName());
    }

    @Test
    void testGetPrice() {
        coffee.setName("sweet cream");
        coffee.setPrice(3);
        coffee.setAmtSugar(3);
        assertEquals(3, coffee.getPrice());
    }

    @Test
    void testSetAmtChocolate() {
        test.setName("test");
        test.setPrice(3);
        test.setAmtChocolate(3);
        assertEquals(3, test.getAmtChocolate());
        test.setAmtChocolate(0);
        assertEquals(0, test.getAmtChocolate());
        test.setAmtChocolate(-1);
        assertEquals(0, test.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffee() {
        test.setName("test");
        test.setPrice(3);
        test.setAmtCoffee(3);
        assertEquals(3, test.getAmtCoffee());
        test.setAmtCoffee(0);
        assertEquals(0, test.getAmtCoffee());
        test.setAmtCoffee(-1);
        assertEquals(0, test.getAmtCoffee());
    }

    @Test
    void testSetAmtMilk() {
        test.setName("test");
        test.setPrice(3);
        test.setAmtMilk(3);
        assertEquals(3, test.getAmtMilk());
        test.setAmtMilk(0);
        assertEquals(0, test.getAmtMilk());
        test.setAmtMilk(-1);
        assertEquals(0, test.getAmtMilk());
    }

    @Test
    void testSetAmtSugar() {
        test.setName("test");
        test.setPrice(3);
        test.setAmtSugar(3);
        assertEquals(3, test.getAmtSugar());
        test.setAmtSugar(0);
        assertEquals(0, test.getAmtSugar());
        test.setAmtSugar(-1);
        assertEquals(0, test.getAmtSugar());
    }

    @Test
    void testSetName() {
        test.setName("test");
        assertEquals("test", test.getName());
    }

    @Test
    void testSetPrice() {
        /* removed for Task 4 - Step 2
        test.setPrice(3);
        assertEquals(3, test.getPrice());
        test.setPrice(0);
        assertEquals(0, test.getPrice());
        test.setPrice(-1);
        assertEquals(0, test.getPrice());
        */
    }

    @Test
    void testToString() {
        assertEquals("coffee", coffee.toString());
    }
    
}
