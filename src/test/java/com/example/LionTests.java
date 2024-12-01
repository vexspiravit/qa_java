package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTests {

    private Feline felineMock;

    @Before
    public void setUpTest() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void constructorMaleLionTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void constructorFemaleLionTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructorInvalidSexTest() throws Exception {
        new Lion("Неизвестно", felineMock);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNonFelinePredatorThrowsExceptionTest() throws Exception {
        Predator nonFelineMock = Mockito.mock(Predator.class);
        new Lion("Самец", nonFelineMock);
    }
}