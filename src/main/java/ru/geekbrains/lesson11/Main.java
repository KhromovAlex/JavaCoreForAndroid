package ru.geekbrains.lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static <T> void replaceItems(T[] array, int indexFirst, int indexSecond) {
        if (indexFirst >= array.length || indexSecond >= array.length) {
            return;
        }

        T firstItem = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = firstItem;
    }

    private static <T> ArrayList<T> arrayListFromArray(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static ArrayList<Byte> arrayListFromArray(byte[] array) {
        ArrayList<Byte> resultArray = new ArrayList<>(array.length);
        for (byte b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Short> arrayListFromArray(short[] array) {
        ArrayList<Short> resultArray = new ArrayList<>(array.length);
        for (short b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Integer> arrayListFromArray(int[] array) {
        ArrayList<Integer> resultArray = new ArrayList<>(array.length);
        for (int b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Long> arrayListFromArray(long[] array) {
        ArrayList<Long> resultArray = new ArrayList<>(array.length);
        for (long b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Float> arrayListFromArray(float[] array) {
        ArrayList<Float> resultArray = new ArrayList<>(array.length);
        for (float b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Double> arrayListFromArray(double[] array) {
        ArrayList<Double> resultArray = new ArrayList<>(array.length);
        for (double b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Character> arrayListFromArray(char[] array) {
        ArrayList<Character> resultArray = new ArrayList<>(array.length);
        for (char b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }

    private static ArrayList<Boolean> arrayListFromArray(boolean[] array) {
        ArrayList<Boolean> resultArray = new ArrayList<>(array.length);
        for (boolean b : array) {
            resultArray.add(b);
        }
        return resultArray;
    }
}
