package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {
    private Feline feline;

    @Before
    public void setFelineUp() {
        feline = new Feline();
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testFelineGetFamily() {
        String expectedFelineFamily = "Кошачьи";
        String actualFelineFamily = feline.getFamily();
        assertEquals(expectedFelineFamily, actualFelineFamily);
    }

    @Test
    public void getKittensWithoutParams() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensWithParams() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}