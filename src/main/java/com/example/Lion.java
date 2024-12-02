package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline; // Инъекция конкретного класса Feline

    // Конструктор с инъекцией зависимости
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.feline = feline;
    }

    // Метод для получения количества детёнышей
    public int getKittens() {
        return feline.getKittens(); // Используем метод Feline напрямую
    }

    // Проверка наличия гривы
    public boolean doesHaveMane() {
        return hasMane;
    }

    // Получение списка пищи
    public List<String> getFood() throws Exception {
        return feline.eatMeat(); // Вызов метода Feline напрямую
    }
}
