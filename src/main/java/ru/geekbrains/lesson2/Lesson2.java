package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i] == 0 ? 1 : 0;
        }

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array2 = new int[8];

        for (int i = 1; i < array2.length; i++) {
            array2[i] = array2[i - 1] + 3;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] matrix = new int[5][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j || i + j == matrix.length - 1) {
                    matrix[i][j] = 1;
                }
            }
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array5 = new int[]{1, 5, 3, 2, 11, 4, -5, 2, 4, 8, 9, -1};
        int min = array5[0];
        int max = array5[0];

        for (int i = 1; i < array5.length; i++) {
            if (array5[i - 1] < min) {
                min = array5[i - 1];
            }
        }

        for (int i = 1; i < array5.length; i++) {
            if (array5[i - 1] > max) {
                max = array5[i - 1];
            }
        }
    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] array) {
        if (array.length < 2) return false;

        int sumLeft;
        int sumRight;
        boolean result = false;

        for (int i = 1; i < array.length; i++) {
            sumLeft = Arrays.stream(Arrays.copyOfRange(array, 0, i)).reduce(0, Integer::sum);
            sumRight = Arrays.stream(Arrays.copyOfRange(array, i, array.length)).reduce(0, Integer::sum);

            if (sumLeft == sumRight) {
                result = true;
                break;
            }
        }

        return result;
    }


    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static int[] shiftArrayElements(int[] array, int offset) {
        if (offset == 0 || array.length < 2) return array;

        if (offset > 0) {
            for (int i = 0; i < offset; i++) {
                for (int j = array.length - 1; j > 0; j--) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        } else {
            for (int i = 0; i > offset; i--) {
                for (int j = 0; j < array.length - 1; j++) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
