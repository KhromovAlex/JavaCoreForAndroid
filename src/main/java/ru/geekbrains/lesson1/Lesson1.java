package ru.geekbrains.lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        byte varByte = 8;
        short varShort = 16;
        int varInteger = 32;
        long varLong = 64000L;

        float varFloat = 32.32f;
        double varDouble = 64.64;

        char varChar = 1050;

        boolean varBool = true;

        String varString = "string";
    }

    public static double calculateFormula(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkParity(int a) {
        System.out.println(a >= 0 ? "положительное" : "отрицательное");
    }

    public static boolean checkNegative(int a) {
        return a < 0;
    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0))) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}

