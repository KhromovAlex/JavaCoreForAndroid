package ru.geekbrains.lesson9;

public class Main {
    public static void main(String[] args) {
        try {
            String[][] array = {
                    {"-7", "1", "5", "0"},
                    {"89", "1", "5", "0"},
                    {"70", "1", "5", "0"},
                    {"65", "1", "5", "0"},
            };
            int sum = sumArray(array);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Не верный размер массива!");
        }

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Не верный размер массива!");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + ", " + j + "] не верные данные!");
                }
            }
        }
        return result;
    }
}
