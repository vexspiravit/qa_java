package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Predator predator;  // Инъекция через интерфейс
    private final Feline feline;      // Используем Feline для getKittens()

    // Конструктор с инъекцией зависимости
    public Lion(String sex, Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.predator = predator;

        // Проверяем, является ли `predator` экземпляром `Feline`
        if (predator instanceof Feline) {
            this.feline = (Feline) predator;
        } else {
            throw new IllegalArgumentException("Predator должен быть экземпляром Feline");
        }
    }

    // Метод для получения количества детёнышей
    public int getKittens() {
        return 1;  // Используем конкретную реализацию Feline
    }

    // Проверка наличия гривы
    public boolean doesHaveMane() {
        return hasMane;
    }

    // Получение списка пищи
    public List<String> getFood() throws Exception {
        return predator.eatMeat();  // Вызов метода интерфейса
    }
}