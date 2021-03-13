package ru.geekbrains.lesson8;

public class Wall implements Barrier {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }
    @Override
    public boolean passObstacle(Participant participant) {
        return participant.jump(height);
    }
}
