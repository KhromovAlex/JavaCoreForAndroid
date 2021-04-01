package ru.geekbrains.lesson14;

import org.junit.jupiter.api.*;

class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testGetRangeArray1() {
        Assertions.assertArrayEquals(new int[]{1, 7}, main.getRangeArray(new int[]{0, 4, 1, 2, 3, 4, 1, 7}));
    }

    @Test
    void testGetRangeArray2() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertArrayEquals(new int[]{}, main.getRangeArray(new int[]{}));
        });
    }

    @Test
    void testGetRangeArray3() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertArrayEquals(new int[]{1, 7}, main.getRangeArray(new int[]{0, 1, 2, 3, 1, 7}));
        });
    }

    @Test
    void testCheckArray1() {
        Assertions.assertFalse(main.checkArray(new int[]{0, 4, 1, 2, 3, 4, 1, 7}));
    }

    @Test
    void testCheckArray2() {
        Assertions.assertTrue(main.checkArray(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    void testCheckArray3() {
        Assertions.assertFalse(main.checkArray(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    void testCheckArray4() {
        Assertions.assertFalse(main.checkArray(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }
}
