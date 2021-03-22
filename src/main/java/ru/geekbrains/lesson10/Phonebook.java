package ru.geekbrains.lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private final Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        ArrayList<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public String get(String name) {
        return phoneBook.get(name).toString();
    }
}
