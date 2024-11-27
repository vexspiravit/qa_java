package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    default int getKittens() {
        return 1;  // Возвращаем дефолтное значение
    }
}
