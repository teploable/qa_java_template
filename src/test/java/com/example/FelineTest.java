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

    //Проверяем, что метод eatMeat() класса  Feline возвращает список Хищник
    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Метод eatMeat должен возвращать список Хищник", expectedFood, actualFood);
    }

    //Проверяем, что метод getFamily() класса Feline возвращает Кошачьи
    @Test
    public void testFelineGetFamily() {
        String expectedFelineFamily = "Кошачьи";
        String actualFelineFamily = feline.getFamily();
        assertEquals("Метод getFamily у Feline должен возвращать Кошачьи", expectedFelineFamily, actualFelineFamily);
    }

    //Проверяем, что метод getKittens() без аргументов возвращает дефолтное значение 1
    @Test
    public void getKittensWithoutParams() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals("Метод getKittens() должен возвращать дефолтное значение 1", expectedKittensCount, actualKittensCount);
    }

    //Проверяем, что метод getKittens() с аргументом kittensCount возвращает значение, переданное в kittensCount
    @Test
    public void getKittensWithParams() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(expectedKittensCount);
        assertEquals("Метод getKittens(kittensCount) должен возвращать заданное значение kittensCount", expectedKittensCount, actualKittensCount);
    }
}