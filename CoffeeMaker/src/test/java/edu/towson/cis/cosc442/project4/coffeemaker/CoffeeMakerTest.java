package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class CoffeeMakerTest {
    
    CoffeeMaker coffeeMaker;
    CoffeeMaker coffeeMaker1;
    CoffeeMaker coffeeMaker2;
    CoffeeMaker coffeeMaker3;

    Recipe coffee = new Recipe();
    Recipe hotcoco = new Recipe();
    Recipe cream = new Recipe();
    Recipe sugar = new Recipe();
    Recipe cocoa = new Recipe();

    @BeforeEach
    void setup() {
        coffee.setName("coffee");
        coffee.setPrice(5);
        coffee.setAmtChocolate(0);
        coffee.setAmtMilk(1);
        coffee.setAmtSugar(2);
        coffee.setAmtCoffee(5);

        hotcoco.setName("hot chocolate");
        hotcoco.setPrice(4);
        hotcoco.setAmtChocolate(5);
        hotcoco.setAmtMilk(3);
        hotcoco.setAmtSugar(2);
        hotcoco.setAmtCoffee(0);

        cream.setName("sweet cream");
        cream.setPrice(3);
        cream.setAmtChocolate(0);
        cream.setAmtMilk(5);
        cream.setAmtSugar(3);
        cream.setAmtCoffee(0);

        sugar.setName("sugar");
        sugar.setPrice(1);
        sugar.setAmtChocolate(0);
        sugar.setAmtMilk(0);
        sugar.setAmtSugar(5);
        sugar.setAmtCoffee(0);

        cocoa.setName("cocoa");
        cocoa.setPrice(1);
        cocoa.setAmtChocolate(5);
        cocoa.setAmtMilk(0);
        cocoa.setAmtSugar(0);
        cocoa.setAmtCoffee(0);

        coffeeMaker = new CoffeeMaker(); // empty coffee maker

        coffeeMaker1 = new CoffeeMaker(); // coffee maker with 1 recipe
        coffeeMaker1.addRecipe(coffee);

        coffeeMaker2 = new CoffeeMaker(); // coffee maker with multiple recipes (recipe maximum)
        coffeeMaker2.addRecipe(coffee);
        coffeeMaker2.addRecipe(hotcoco);
        coffeeMaker2.addRecipe(cream);
        coffeeMaker2.addRecipe(sugar);
        coffeeMaker2.addRecipe(cocoa);

        coffeeMaker3 = new CoffeeMaker();
    }

    @AfterEach
    void tearDown() {
        coffeeMaker = null;
        coffeeMaker1 = null;
        coffeeMaker2 = null;
        coffeeMaker3 = null;
    }

    @Test
    void testAddInventory() {
        /* removed for Task 4 - Step 2
        coffeeMaker3.addInventory(1, 0, 0,0);
        assertEquals(16, coffeeMaker3.checkInventory().getCoffee());
        coffeeMaker3.addInventory(0, 1, 0,0);
        assertEquals(16, coffeeMaker3.checkInventory().getMilk());
        coffeeMaker3.addInventory(0, 0, 1,0);
        assertEquals(16, coffeeMaker3.checkInventory().getSugar());
        coffeeMaker3.addInventory(0, 0, 0,1);
        assertEquals(16, coffeeMaker3.checkInventory().getChocolate()); */

        int[] i = {1, 1, 1, 1};
        for (int x = 0; x <= 1; x++) {
            for (int y = 0; y <= 3; y++) {
                i[y] = x;
                assertTrue(coffeeMaker.addInventory(i[0], i[1], i[2], i[3]));
                if (x == 0) {
                    i[y] = 1;
                } else {
                    i[y] = 0;
                }
            }
            for (int y = 0; y <= 3; y++) {
                i[y] = 0;
            }
        }
        assertTrue(coffeeMaker.addInventory(1, 1, 1, 1));
        assertTrue(coffeeMaker.addInventory(0, 0, 0,0));
        assertFalse(coffeeMaker.addInventory(-1, -1, -1, -1));
    }

    @Test
    void testAddRecipe() {
        assertTrue(coffeeMaker.addRecipe(coffee)); // add coffee recipe to empty coffee maker
        assertTrue(coffeeMaker1.addRecipe(hotcoco)); // add hot chocolate recipe to coffee maker with 1 recipe
        assertFalse(coffeeMaker1.addRecipe(hotcoco)); // try to add the same recipe again
        assertFalse(coffeeMaker2.addRecipe(cream)); // try to add a recipe to the coffee maker with the maximum number of recipes
    }

    @Test
    void testCheckInventory() {
        assertEquals(15, coffeeMaker.checkInventory().getCoffee());
    }

    @Test
    void testDeleteRecipe() {
        assertFalse(coffeeMaker.deleteRecipe(coffee)); // delete coffee recipe from coffee maker without recipes
        assertFalse(coffeeMaker1.deleteRecipe(cream)); // try to delete a recipe that doesn't exist in the coffee maker
        assertTrue(coffeeMaker2.deleteRecipe(cream)); // delete cream recipe from coffee maker with multiple recipes
        assertFalse(coffeeMaker2.deleteRecipe(cream)); // try to delete the same recipe again
        assertFalse(coffeeMaker.deleteRecipe(null)); // try to delete a null recipe
    }

    @Test
    void testEditRecipe() {
        assertTrue(coffeeMaker1.editRecipe(coffee, hotcoco)); // edit coffee recipe to hot chocolate recipe
        assertFalse(coffeeMaker.editRecipe(coffee, cream)); // try to edit a recipe that doesn't exist in the coffee maker
        assertTrue(coffeeMaker2.editRecipe(cream, cream)); // edit recipe with self
    }

    @Test
    void testGetRecipeForName() {
        assertNotEquals(coffee, coffeeMaker.getRecipeForName("coffee"));
        assertEquals(coffee, coffeeMaker1.getRecipeForName("coffee"));
        assertEquals(coffee, coffeeMaker2.getRecipeForName("COFFEE"));
        Recipe[] valid = {coffee, hotcoco, cream, sugar, cocoa};
        boolean test = true;
        for (int i = 0; i < valid.length; i++) {
            if ("nonexistentrecipe".equalsIgnoreCase(valid[i].getName())) {
                test = false;
            }
        }
        assertTrue(test);
    }

    @Test
    void testGetRecipes() {
        Recipe[] expectedRecipes = {coffee, hotcoco, cream, sugar, cocoa};
        assertEquals(4, coffeeMaker2.getRecipes().length);
        for (int i = 0; i < 4; i++) {
            boolean test = false;
            for (int j = 0; j < 4; j++) {
                if (expectedRecipes[i] == coffeeMaker2.getRecipes()[j]){
                    test = true;
                }
            }
            assertTrue(test);
        }
    }

    @Test
    void testMakeCoffee() {
        assertEquals(0, coffeeMaker2.makeCoffee(coffee, 0)); // try to make coffee with insufficient payment
        assertEquals(0, coffeeMaker2.makeCoffee(sugar, 1)); // try to make item with sufficient payment
        assertEquals(0, coffeeMaker2.makeCoffee(sugar, 1));
        assertEquals(0, coffeeMaker2.makeCoffee(sugar, 1));
        assertEquals(1, coffeeMaker2.makeCoffee(sugar, 1)); // try to make item with insufficient inventory
    }

    @Test
    void testMakeCoffeeInventoryCheck() {
        coffeeMaker3.makeCoffee(coffee, 5);
        assertEquals(10, coffeeMaker3.checkInventory().getCoffee());
        assertEquals(14, coffeeMaker3.checkInventory().getMilk());
        assertEquals(13, coffeeMaker3.checkInventory().getSugar());
        coffeeMaker3.makeCoffee(hotcoco, 4);
        assertEquals(10, coffeeMaker3.checkInventory().getChocolate());
    }
}