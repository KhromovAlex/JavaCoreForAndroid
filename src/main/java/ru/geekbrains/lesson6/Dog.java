package ru.geekbrains.lesson6;

public class Dog extends Animal{
    public static int countDog = 0;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.printf("%1$s пробежал %2$s м.\n", name, length);
        } else {
            System.out.printf("%s столько не пробежит ;-(\n", name);
        }
    }

    @Override
    public void sail(int length) {
        if (length <= 10) {
            System.out.printf("%1$s проплыл %2$s м.\n", name, length);
        } else {
            System.out.printf("%s столько не проплывет ;-(\n", name);
        }
    }
}
