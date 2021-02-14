package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Task2 {
    public static void main(String[] args) {
        start();
    }

    private static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void start() {
        final Random random = new Random();
        String randomWord = WORDS[random.nextInt(WORDS.length - 1)];
        char[] currentWordAsArray = new char[15];
        Arrays.fill(currentWordAsArray, '#');
        Scanner scanner = new Scanner(System.in);
        System.out.println("Угадай слово!");
        int count = 0;

        while (true) {
            String inputString = scanner.nextLine().toLowerCase();
            count++;
            if (inputString.equals(randomWord.toLowerCase())) {
                System.out.printf("Вы угадали с %2$s попытки! Загаданное слово: %1$s\n", randomWord, count);
                scanner.close();
                break;
            } else {
                for (int i = 0; i < inputString.length(); i++) {
                    if (i >= randomWord.length()) break;
                    currentWordAsArray[i] = inputString.charAt(i) == randomWord.charAt(i) ? inputString.charAt(i) : currentWordAsArray[i];
                }
            }
            System.out.printf("Попробуйте еще раз! %s\n", new String(currentWordAsArray));
        }
    }
}

