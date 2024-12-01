package com.example;

import java.util.Arrays;
import java.util.List;

public class Feline implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return Arrays.asList("Мясо", "Птица", "Рыба");
    }

    public int getKittens() {
        return 1;
    }

    public String getFamily() {
        return "Кошачьи";
    }
}
