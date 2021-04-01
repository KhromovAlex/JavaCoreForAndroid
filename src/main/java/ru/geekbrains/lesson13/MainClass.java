package ru.geekbrains.lesson13;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        ConcurrentLinkedDeque<String> ternWinnerName = new ConcurrentLinkedDeque<>();
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch cdlStartAwait = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlFinishAwait = new CountDownLatch(CARS_COUNT);
        CyclicBarrier cbStartAwait = new CyclicBarrier(CARS_COUNT);
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        ExecutorService executor = Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdlStartAwait, cdlFinishAwait, cbStartAwait, semaphore, ternWinnerName);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            cdlStartAwait.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            cdlFinishAwait.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победил - " + ternWinnerName.getFirst());
    }
}
