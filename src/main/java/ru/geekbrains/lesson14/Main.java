package ru.geekbrains.lesson14;

import java.util.Arrays;

public class Main {
    public int[] getRangeArray(int[] array) {
        int index = -1;

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == 4) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new RuntimeException();
        }

        return Arrays.copyOfRange(array, index + 1, array.length);
    }

    public boolean checkArray(int[] array) {
        boolean contains1 = false;
        boolean contains4 = false;

        for (int i : array) {
            if (i != 1 && i != 4) {
                return false;
            }
            contains1 = i == 1 || contains1;
            contains4 = i == 4 || contains4;
        }

        return contains1 && contains4;
    }
}
