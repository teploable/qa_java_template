package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
    }

    //Проверяем проброс исключения, если значение sex было передано любое, кроме валидных Самец или Самка
    @Test
    public void testLionWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Какой-то лев", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    //Проверяем, что метод getKittens() обращается к методу класса Feline и возвращает дефолтное значение 1
    @Test
    public void testLionGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion = new Lion("Самец", feline);
        assertEquals("Метод getKittens у Lion возвращает дефолтное значение", 1, lion.getKittens());
    }

    //Проверяем, что getFood() класса Lion обращается к методу класса Feline и возвращает список Хищник
    @Test
    public void testLionGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion("Самка", feline);

        List<String> actualFood = lion.getFood();
        assertEquals("Метод getFood у Lion возвращает список Хищник", expectedFood, actualFood);
    }
}