package ru.geekbrains.lesson11;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public ArrayList<T> getFruits() {
        return fruits;
    }

    private void cleanBox() {
        fruits.clear();
    }

    public void addFruit(T fruit) {
       fruits.add(fruit);
    }

    public void addBoxFruits(ArrayList<T> boxFruits) {
        fruits.addAll(boxFruits);
    }

    public double getWeight() {
        return fruits.size() == 0 ? 0 : fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveAllFruits(Box<T> box) {
        box.addBoxFruits(this.getFruits());
        cleanBox();
    }
}
