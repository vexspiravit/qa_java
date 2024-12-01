package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTests {

    private Feline feline;

    @Before
    public void setUpTest() {
        // Создаём объект Feline, не используя моки
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsCorrectFoodListTest() {
        // Ожидаемый список еды
        List<String> expectedFood = List.of("Мясо", "Птица", "Рыба");
        List<String> actualFood = null;

        try {
            // Вызываем метод eatMeat
            actualFood = feline.eatMeat();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Проверяем, что список еды соответствует ожидаемому
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyReturnsCorrectFamilyNameTest() {
        // Проверяем, что getFamily возвращает "Кошачьи"
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameterReturnsDefaultNumberTest() {
        // Проверяем, что метод getKittens без параметра возвращает 1
        assertEquals(1, feline.getKittens());
    }
}