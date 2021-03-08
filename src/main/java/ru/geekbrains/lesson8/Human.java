package ru.geekbrains.lesson8;

public class Human implements Participant{
    private final int MAX_HEIGHT_JUMP = 1;
    private final int MAX_LENGTH_RUN = 500;

    @Override
    public boolean jump(int height) {
        boolean result = height <= MAX_HEIGHT_JUMP;
        System.out.printf(result ? "Человек перепрыгнул стену высотой %s\n" : "Человек так высоко не прыгает ;-(\n", height);
        return result;
    }

    @Override
    public boolean run(int length) {
        boolean result = length <= MAX_LENGTH_RUN;
        System.out.printf(result ? "Человек пробежал %s\n" : "Человек устал и не смог больше бежать ;-(\n", length);
        return result;
    }
}
