package ru.geekbrains.lesson8;

public class Robot implements Participant{
    private final int MAX_HEIGHT_JUMP = 3;
    private final int MAX_LENGTH_RUN = 1000;

    @Override
    public boolean jump(int height) {
        boolean result = height <= MAX_HEIGHT_JUMP;
        System.out.printf(result ? "Робот перепрыгнул стену высотой %s\n" : "Робот сломался ;-(\n", height);
        return result;
    }

    @Override
    public boolean run(int length) {
        boolean result = length <= MAX_LENGTH_RUN;
        System.out.printf(result ? "Робот пробежал %s\n" : "Робот сломался ;-(\n", length);
        return result;
    }
}
