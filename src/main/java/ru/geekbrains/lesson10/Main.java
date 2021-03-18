package ru.geekbrains.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        String[] arrayWords = {
                "welcome",
                "cat",
                "window",
                "girl",
                "door",
                "winter",
                "dug",
                "cat",
                "cat",
                "welcome",
                "door"
        };

        Map<String, Integer> mapUniqueWords = new HashMap<>();

        for (String word : arrayWords) {
            int count = mapUniqueWords.getOrDefault(word, 0);
            mapUniqueWords.put(word, count + 1);
        }

        System.out.println(mapUniqueWords);
    }

    static void task2() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ira", "89008000102");
        phonebook.add("Ira", "89001230102");
        phonebook.add("Ivan", "89008456102");
        phonebook.add("Alex", "89007890102");

        System.out.println(phonebook.get("Ira"));
    }
}
