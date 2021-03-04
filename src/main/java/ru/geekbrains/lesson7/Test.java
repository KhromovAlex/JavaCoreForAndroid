package ru.geekbrains.lesson7;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Cat[] cats = {
                new Cat("Martin"),
                new Cat("Vasya"),
                new Cat("Pushka"),
                new Cat("Sreda"),
                new Cat("Ololosha")
        };
        Plate plate = new Plate(15);

        for (Cat cat: cats) {
            cat.eat(plate);
            String isSatiety = cat.isSatiety() ? "сытый" : "голодный ;-(";
            System.out.printf("%1s, %2s! ", cat.getName(), isSatiety);
            plate.printInfo();
        }

    }
}