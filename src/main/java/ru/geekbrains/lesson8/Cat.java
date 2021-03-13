package ru.geekbrains.lesson8;

public class Cat implements Participant{
    private final int MAX_HEIGHT_JUMP = 2;
    private final int MAX_LENGTH_RUN = 300;

    @Override
    public boolean jump(int height) {
        boolean result = height <= MAX_HEIGHT_JUMP;
        System.out.printf(result ? "Кот перепрыгнул стену высотой %s\n" : "Кот так высоко не прыгает ;-(\n", height);
        return result;
    }

    @Override
    public boolean run(int length) {
        boolean result = length <= MAX_LENGTH_RUN;
        System.out.printf(result ? "Кот пробежал %s\n" : "Кот устал и не смог больше бежать ;-(\n", length);
        return result;
    }
}
