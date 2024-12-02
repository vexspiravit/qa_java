package com.example;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTests {

    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUpTest() {
        // Создаём мок для Feline, так как он реализует Predator
        felineMock = Mockito.mock(Feline.class);
        // Передаём мок в конструктор Cat
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsCorrectSoundTest() {
        // Проверяем, что getSound возвращает "Мяу"
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsCorrectFoodListTest() throws Exception {
        // Настраиваем поведение мока
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Проверяем, что getFood возвращает результат мока
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void getFoodCallsEatMeatOnceTest() throws Exception {
        // Вызываем метод, чтобы проверить взаимодействие
        cat.getFood();

        // Проверяем, что метод eatMeat был вызван один раз
        verify(felineMock, times(1)).eatMeat();
    }
}