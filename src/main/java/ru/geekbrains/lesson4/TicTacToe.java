package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final int SIZE = 9;
    static int WIN_SIZE = SIZE < 6 ? 3 : SIZE >= 10 ? 5 : 4;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '♥';
    static final String EMPTY = " ";

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount;
    static final int[] lastPositionTurnHuman = new int[2];
    static final int[] lastPositionTurnAI = new int[2];


    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {

        //инициализация поля
        initMap();

        //печать поля в консоль
        printMap();

        //игра
        playGame();

    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        //печать заголовка
        printHeaderMap();

        //печать поля
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.printf("%2s", HEADER_FIRST_SYMBOL);

        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();

    }

    private static void printMapNumber(int i) {
        int number = i + 1;
        System.out.printf("%2d" + EMPTY, number);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%-2s" + EMPTY, MAP[i][j]);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);


            turnAI();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid;


        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбик: ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }

        } while (!(isInputValid && isHumanTurnValid(rowNumber, columnNumber)));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        lastPositionTurnHuman[0] = rowNumber;
        lastPositionTurnHuman[1] = columnNumber;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне размера игрового поля");
        in.next();
    }

    private static boolean isHumanTurnValid(int rowNumber, int columnNumber) {
        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        } else if (!isCellOccupancy(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber >= SIZE || rowNumber < 0 || columnNumber >= SIZE || columnNumber < 0);
    }

    private static boolean isCellOccupancy(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }


    private static void checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил...");
            }
            System.exit(0);
        } else if (isMapFull()) {
            System.out.println("Ничья!");
            System.exit(0);
        }
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {
        int[] lastPositionTurn = symbol == DOT_HUMAN ? lastPositionTurnHuman : lastPositionTurnAI;

        return checkWinRow(symbol, lastPositionTurn[0]) ||
                checkWinColumn(symbol, lastPositionTurn[1]) ||
                checkWinMainDiagonal(symbol, lastPositionTurn) ||
                checkWinCrossDiagonal(symbol, lastPositionTurn);

    }

    private static boolean checkWinRow(char symbol, int indexRow) {
        int countSymbols = 0;

        for (int i = 0; i < SIZE; i++) {
            countSymbols = MAP[indexRow][i] == symbol ? countSymbols + 1 : 0;

            if (countSymbols == WIN_SIZE) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWinColumn(char symbol, int indexColumn) {
        int countSymbols = 0;

        for (int i = 0; i < SIZE; i++) {
            countSymbols = MAP[i][indexColumn] == symbol ? countSymbols + 1 : 0;

            if (countSymbols == WIN_SIZE) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWinMainDiagonal(char symbol, int[] lastPositionTurn) {
        int countSymbols = 0;
        int startRowPosition = getFirstRowMainDiagonal(lastPositionTurn);
        int startColumnPosition = getFirstColumnMainDiagonal(lastPositionTurn);
        int lengthDiagonal = getLengthMainDiagonal(startRowPosition, startColumnPosition);

        for (int i = 0; i < lengthDiagonal; i++) {
            countSymbols = MAP[startRowPosition + i][startColumnPosition + i] == symbol ? countSymbols + 1 : 0;

            if (countSymbols == WIN_SIZE) {
                return true;
            }
        }

        return false;
    }

    private static int getFirstRowMainDiagonal(int[] positionTurn) {
        if (positionTurn[0] > positionTurn[1]) {
            return positionTurn[0] - positionTurn[1];
        } else {
            return 0;
        }
    }

    private static int getFirstColumnMainDiagonal(int[] positionTurn) {
        if (positionTurn[0] < positionTurn[1]) {
            return positionTurn[1] - positionTurn[0];
        } else {
            return 0;
        }
    }

    private static int getLengthMainDiagonal(int firstRow, int firstColumn) {
        if (firstRow > firstColumn) {
            return SIZE - firstRow - firstColumn;
        } else if (firstRow < firstColumn) {
            return SIZE - firstColumn - firstRow;
        } else {
            return SIZE;
        }
    }

    private static boolean checkWinCrossDiagonal(char symbol, int[] lastPositionTurn) {
        int countSymbols = 0;
        int startRowPosition = getFirstRowCrossDiagonal(lastPositionTurn);
        int startColumnPosition = getFirstColumnCrossDiagonal(lastPositionTurn);
        int lengthDiagonal = getLengthCrossDiagonal(startRowPosition, startColumnPosition);


        for (int i = 0; i < lengthDiagonal; i++) {
            countSymbols = MAP[startRowPosition + i][startColumnPosition - i] == symbol ? countSymbols + 1 : 0;

            if (countSymbols == WIN_SIZE) {
                return true;
            }
        }

        return false;
    }

    private static int getFirstRowCrossDiagonal(int[] positionTurn) {
        if (positionTurn[0] + positionTurn[1] < SIZE) {
            return 0;
        } else {
            return positionTurn[0] + positionTurn[1] - SIZE + 1;
        }
    }

    private static int getFirstColumnCrossDiagonal(int[] positionTurn) {
        if (positionTurn[0] + positionTurn[1] < SIZE) {
            return positionTurn[0] + positionTurn[1];
        } else {
            return SIZE - 1;
        }
    }

    private static int getLengthCrossDiagonal(int firstRow, int firstColumn) {
        if (firstRow + firstColumn < SIZE) {
            return firstRow + firstColumn + 1;
        } else {
            return (SIZE - 1) - (firstRow + firstColumn - SIZE + 1) + 1;
        }
    }

    private static void turnAI() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера!");

        int[] lockRowPosition = searchLockPosition();

        rowNumber = lockRowPosition[0];
        columnNumber = lockRowPosition[1];

        while ((rowNumber == -1) || !isCellOccupancy(rowNumber, columnNumber)) {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        }

        MAP[rowNumber][columnNumber] = DOT_AI;
        lastPositionTurnAI[0] = rowNumber;
        lastPositionTurnAI[1] = columnNumber;
        turnsCount++;
    }

    private static int[] searchLockPosition() {
        String[] patternLock = getLockPattern();
        int searchRowPosition = -1;
        int searchColumnPosition = -1;

        int[] rowLock = searchRowLock(patternLock);
        int[] columnLock = searchColumnLock(patternLock);
        int[] mainDiagonalLock = searchMainDiagonalLock(patternLock);
        int[] crossDiagonalLock = searchCrossDiagonalLock(patternLock);

        int[][] lockArray = new int[][]{
                rowLock,
                columnLock,
                mainDiagonalLock,
                crossDiagonalLock
        };

        for (int[] ints : lockArray) {
            if (ints[0] != -1) {
                searchRowPosition = ints[0];
                searchColumnPosition = ints[1];
                break;
            }
        }

        return new int[]{
                searchRowPosition,
                searchColumnPosition
        };

    }

    private static int[] searchRowLock(String[] patternLock) {
        StringBuilder orderDot = new StringBuilder();
        int countEmptySymbol = 0;
        int searchRowPosition = -1;
        int searchColumnPosition = -1;
        int[] result = new int[]{searchRowPosition, searchColumnPosition};

        for (int i = 0; i < SIZE; i++) {
            if (MAP[lastPositionTurnHuman[0]][i] == DOT_HUMAN) {
                orderDot.append(DOT_HUMAN);
            } else if (MAP[lastPositionTurnHuman[0]][i] == DOT_EMPTY) {
                orderDot.append(DOT_EMPTY);
                countEmptySymbol++;
                searchRowPosition = lastPositionTurnHuman[0];
                searchColumnPosition = i;
            } else {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (countEmptySymbol == 2) {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (orderDot.length() == WIN_SIZE) {
                for (String s : patternLock) {
                    if (s.equals(orderDot.toString())) {
                        result[0] = searchRowPosition;
                        result[1] = searchColumnPosition;
                        return result;
                    }
                }
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }
        }

        return result;
    }

    private static int[] searchColumnLock(String[] patternLock) {
        StringBuilder orderDot = new StringBuilder();
        int countEmptySymbol = 0;
        int searchRowPosition = -1;
        int searchColumnPosition = -1;
        int[] result = new int[]{searchRowPosition, searchColumnPosition};

        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][lastPositionTurnHuman[1]] == DOT_HUMAN) {
                orderDot.append(DOT_HUMAN);
            } else if (MAP[i][lastPositionTurnHuman[1]] == DOT_EMPTY) {
                orderDot.append(DOT_EMPTY);
                countEmptySymbol++;
                searchRowPosition = i;
                searchColumnPosition = lastPositionTurnHuman[1];
            } else {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (countEmptySymbol == 2) {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (orderDot.length() == WIN_SIZE) {
                for (String s : patternLock) {
                    if (s.equals(orderDot.toString())) {
                        result[0] = searchRowPosition;
                        result[1] = searchColumnPosition;
                        return result;
                    }
                }
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }
        }

        return result;
    }

    private static int[] searchMainDiagonalLock(String[] patternLock) {
        StringBuilder orderDot = new StringBuilder();
        int countEmptySymbol = 0;
        int searchRowPosition = -1;
        int searchColumnPosition = -1;
        int[] result = new int[]{searchRowPosition, searchColumnPosition};
        int startRowPosition = getFirstRowMainDiagonal(lastPositionTurnHuman);
        int startColumnPosition = getFirstColumnMainDiagonal(lastPositionTurnHuman);
        int lengthDiagonal = getLengthMainDiagonal(startRowPosition, startColumnPosition);

        for (int i = 0; i < lengthDiagonal; i++) {
            if (MAP[startRowPosition + i][startColumnPosition + i] == DOT_HUMAN) {
                orderDot.append(DOT_HUMAN);
            } else if (MAP[startRowPosition + i][startColumnPosition + i] == DOT_EMPTY) {
                orderDot.append(DOT_EMPTY);
                countEmptySymbol++;
                searchRowPosition = startRowPosition + i;
                searchColumnPosition = startColumnPosition + i;
            } else {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (countEmptySymbol == 2) {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (orderDot.length() == WIN_SIZE) {
                for (String s : patternLock) {
                    if (s.equals(orderDot.toString())) {
                        result[0] = searchRowPosition;
                        result[1] = searchColumnPosition;
                        return result;
                    }
                }
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }
        }

        return result;
    }

    private static int[] searchCrossDiagonalLock(String[] patternLock) {
        StringBuilder orderDot = new StringBuilder();
        int countEmptySymbol = 0;
        int searchRowPosition = -1;
        int searchColumnPosition = -1;
        int[] result = new int[]{searchRowPosition, searchColumnPosition};
        int startRowPosition = getFirstRowCrossDiagonal(lastPositionTurnHuman);
        int startColumnPosition = getFirstColumnCrossDiagonal(lastPositionTurnHuman);
        int lengthDiagonal = getLengthCrossDiagonal(startRowPosition, startColumnPosition);

        for (int i = 0; i < lengthDiagonal; i++) {
            if (MAP[startRowPosition + i][startColumnPosition - i] == DOT_HUMAN) {
                orderDot.append(DOT_HUMAN);
            } else if (MAP[startRowPosition + i][startColumnPosition - i] == DOT_EMPTY) {
                orderDot.append(DOT_EMPTY);
                countEmptySymbol++;
                searchRowPosition = startRowPosition + i;
                searchColumnPosition = startColumnPosition - i;
            } else {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (countEmptySymbol == 2) {
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }

            if (orderDot.length() == WIN_SIZE) {
                for (String s : patternLock) {
                    if (s.equals(orderDot.toString())) {
                        result[0] = searchRowPosition;
                        result[1] = searchColumnPosition;
                        return result;
                    }
                }
                i = i - orderDot.length() + 1;
                orderDot.setLength(0);
                countEmptySymbol = 0;
            }
        }

        return result;
    }

    private static String[] getLockPattern() {

        return switch (WIN_SIZE) {
            case 3 -> new String[]{
                    "" + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY,
            };
            case 4 -> new String[]{
                    "" + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY,
            };
            case 5 -> new String[]{
                    "" + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY + DOT_HUMAN,
                    "" + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN + DOT_HUMAN + DOT_EMPTY,
            };
            default -> new String[0];
        };
    }
}
