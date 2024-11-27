package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Predator predator;  // Инъекция зависимости через конструктор

    // Конструктор с инъекцией зависимости
    public Lion(String sex, Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.predator = predator;  // Инъекция зависимости
    }

    // Метод для получения количества детёнышей
    public int getKittens() {
        return predator.getKittens();
    }

    // Проверка наличия гривы
    public boolean doesHaveMane() {
        return hasMane;
    }

    // Получение списка пищи
    public List<String> getFood() throws Exception {
        return predator.eatMeat();  // В классе Lion, вызываем метод eatMeat() у predator
    }
}

