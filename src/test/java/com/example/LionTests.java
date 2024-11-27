package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTests {

    private Predator predatorMock;  // Мок Predator (Feline)

    @Before
    public void setUp() {
        // Создаем мок для Predator (например, Feline)
        predatorMock = Mockito.mock(Predator.class);
    }

    @Test
    public void testConstructorMaleLion() throws Exception {
        // Проверяем, что у "Самца" грива есть
        Lion lion = new Lion("Самец", predatorMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemaleLion() throws Exception {
        // Проверяем, что у "Самки" грива отсутствует
        Lion lion = new Lion("Самка", predatorMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        // Проверяем, что при некорректном поле выбрасывается исключение
        new Lion("Неизвестно", predatorMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        // Настроим поведение мока для метода getKittens
        when(predatorMock.getKittens()).thenReturn(3);

        // Создаем экземпляр Lion с моком Predator (например, Feline)
        Lion lion = new Lion("Самец", predatorMock);

        // Проверяем результат
        assertEquals(3, lion.getKittens());
        verify(predatorMock, times(1)).getKittens(); // Проверка, что метод был вызван один раз
    }

    @Test
    public void testGetFood() throws Exception {
        // Настроим поведение мока для predator (Feline)
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Создаем экземпляр Lion с моком Predator (например, Feline)
        Lion lion = new Lion("Самка", predatorMock);

        // Проверим, что результат вызова getFood совпадает с ожидаемым
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(predatorMock, times(1)).eatMeat();  // Убедимся, что eatMeat() был вызван
    }
}