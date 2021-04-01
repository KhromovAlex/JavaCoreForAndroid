package ru.geekbrains.lesson13;

import java.util.concurrent.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch cdlStartAwait;
    private final CountDownLatch cdlFinishAwait;
    private final CyclicBarrier cbStartAwait;
    private final Semaphore semaphore;
    ConcurrentLinkedDeque<String> ternWinnerName;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdlStartAwait, CountDownLatch cdlFinishAwait, CyclicBarrier cbStartAwait, Semaphore semaphore, ConcurrentLinkedDeque<String> ternWinnerName) {
        this.race = race;
        this.speed = speed;
        this.cdlStartAwait = cdlStartAwait;
        this.cdlFinishAwait = cdlFinishAwait;
        this.cbStartAwait = cbStartAwait;
        this.semaphore = semaphore;
        this.ternWinnerName = ternWinnerName;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlStartAwait.countDown();
            cbStartAwait.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            if (race.getStages().get(i) instanceof Tunnel) {
                try {
                    semaphore.acquire();
                    race.getStages().get(i).go(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            } else {
                race.getStages().get(i).go(this);
            }
        }
        cdlFinishAwait.countDown();
        ternWinnerName.add(this.name);
    }

}
