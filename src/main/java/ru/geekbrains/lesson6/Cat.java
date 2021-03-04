package ru.geekbrains.lesson6;

public class Cat extends Animal{
    public static int countCat = 0;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.printf("%1$s пробежал %2$s м.\n", name, length);
        } else {
            System.out.printf("%s столько не пробежит ;-(\n", name);
        }
    }

    @Override
    public void sail(int length) {
        System.out.printf("%s не умеет плавать!\n", name);
    }
}
