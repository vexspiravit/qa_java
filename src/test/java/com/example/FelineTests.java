import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FelineTests {

    private Feline feline;
    private Animal animalMock;

    @Before
    public void setUp() {
        // Используем мок Animal, так как Feline наследуется от Animal
        animalMock = Mockito.mock(Animal.class);
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        // Мокаем метод getFood("Хищник")
        when(animalMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        // Вызываем метод
        List<String> food = feline.eatMeat();
        // Проверяем результат
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        // Проверяем метод getFamily
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParameter() {
        // Проверяем метод getKittens без параметра
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        // Проверяем метод getKittens с параметром
        assertEquals(3, feline.getKittens(3));
    }
}
