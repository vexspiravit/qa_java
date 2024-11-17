import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTests {

    private Feline felineMock;

    @Before
    public void setUp() {
        // Создаем мок для Feline
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testConstructorMaleLion() throws Exception {
        // Проверяем, что у "Самца" грива есть
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemaleLion() throws Exception {
        // Проверяем, что у "Самки" грива отсутствует
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        // Проверяем, что при некорректном поле выбрасывается исключение
        new Lion("Неизвестно", felineMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        // Настраиваем поведение мока
        when(felineMock.getKittens()).thenReturn(3);

        // Создаем экземпляр Lion с моком Feline
        Lion lion = new Lion("Самец", felineMock);

        // Проверяем результат
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем поведение мока
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Создаем экземпляр Lion с моком Feline
        Lion lion = new Lion("Самка", felineMock);

        // Проверяем результат
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(felineMock, times(1)).getFood("Хищник");
    }
}


