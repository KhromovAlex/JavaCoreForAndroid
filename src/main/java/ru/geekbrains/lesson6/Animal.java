package ru.geekbrains.lesson6;

public abstract class Animal {
    public static int countAnimal = 0;
    protected final String name;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    public abstract void run(int length);

    public abstract void sail(int length);
}
