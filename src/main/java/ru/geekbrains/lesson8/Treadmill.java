package ru.geekbrains.lesson8;

public class Treadmill implements Barrier {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }
    @Override
    public boolean passObstacle(Participant participant) {
        return participant.run(length);
    }
}
