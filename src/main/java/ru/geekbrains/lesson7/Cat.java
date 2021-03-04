package ru.geekbrains.lesson7;

import java.util.Random;

public class Cat {
    private final String name;
    private boolean satiety = false;
    private final Random random = new Random();

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        int rightAmountFood = random.nextInt(4) + 3;
        int currentFoodPlate = plate.getFood();

        if (currentFoodPlate >= rightAmountFood && !satiety) {
            plate.decreaseFood(rightAmountFood);
            satiety = true;
        }
    }
}
