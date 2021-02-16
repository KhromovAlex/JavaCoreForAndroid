package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Task1 {
    public static void main(String[] args) {
        start();
    }

    static private final int MAX_COUNT = 3;

    public static void start() {
        int count;
        int randomNumber;
        final Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int currentNumber;
        boolean result;
        int retryCode;

        while (true) {
            count = 0;
            randomNumber = random.nextInt(10);
            result = false;

            System.out.println("Угадай число!");

            while (count < MAX_COUNT) {
                System.out.printf("Введи число от 0 до 9! Количество попыток: %d.\n", MAX_COUNT - count);

                if (scanner.hasNextInt()) {
                    currentNumber = scanner.nextInt();
                    if (currentNumber > randomNumber) {
                        System.out.println("Ты ввел большое число");
                    } else if (currentNumber < randomNumber) {
                        System.out.println("Ты ввел маленькое число");
                    } else {
                        result = true;
                        break;
                    }
                } else {
                    scanner.next();
                    System.out.println("Введено не число!");
                    continue;
                }

                count++;
            }

            if (result) {
                System.out.printf("Молодец! Ты угадал с %2$d попытки! Загаданное число - %1$d.\n", randomNumber, count + 1);
            } else {
                System.out.printf("Не угадал ;-( Загаданное число - %d.\n", randomNumber);
            }

            while (true) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                if (scanner.hasNextInt()) {
                    retryCode = scanner.nextInt();
                    if (retryCode == 1 || retryCode == 0) {
                        break;
                    }
                } else {
                    scanner.next();
                }
            }

            if (retryCode == 0) {
                scanner.close();
                break;
            }

        }
    }
}
