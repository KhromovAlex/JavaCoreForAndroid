package ru.geekbrains.lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Participant[] participants = {
                new Cat(),
                new Human(),
                new Robot()
        };
        Barrier[] barriers = {
                new Treadmill(random.nextInt(1200)),
                new Wall(random.nextInt(4)),
                new Treadmill(random.nextInt(1200)),
                new Wall(random.nextInt(4)),
                new Treadmill(random.nextInt(1200)),
                new Wall(random.nextInt(4)),
                new Treadmill(random.nextInt(1200)),
                new Wall(random.nextInt(4)),
        };

        for (Participant participant: participants) {
            for (Barrier barrier: barriers) {
                if (!barrier.passObstacle(participant)) {
                    break;
                }
            }
        }
    }
}
