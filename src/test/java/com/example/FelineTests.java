package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineTests {

    private Feline feline;

    @Before
    public void setUpTest() {
        // Инициализация объекта Feline
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsCorrectFoodListTest() throws Exception {
        // Ожидаемый список еды
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        // Вызываем метод eatMeat
        List<String> actualFood = feline.eatMeat();
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

    @Test
    public void getKittensWithParameterReturnsSpecifiedNumberTest() {
        // Проверяем, что метод getKittens с параметром возвращает указанное значение
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void getFoodThrowsExceptionForInvalidTypeTest() {
        // Убедимся, что метод выбрасывает исключение для некорректного типа животного
        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood("НекорректныйТип");
        });
        // Проверяем сообщение исключения
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}