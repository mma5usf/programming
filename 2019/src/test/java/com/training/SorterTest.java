package com.training;

import java.util.Arrays;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 *  Test by Pradyumna Achar
 *  https://github.com/prkadalb/practice/blob/master/src/test/java/com/training/SorterTest.java
 */
public class SorterTest {
    @DataProvider(name = "sortDataProvider")
    public Object[][] sortDataProvider() {
        return new Object[][] {
                {new int[0], new int[0]},
                {new int[] {0}, new int[] {0}},
                {new int[] {0, 1}, new int[] {0, 1}},
                {new int[] {0, 1, 2}, new int[] {0, 1, 2}},
                {new int[] {1, 0}, new int[] {0, 1}},
                {new int[] {2, 1, 0}, new int[] {0, 1, 2}},
                {new int[] {0, 2, 1}, new int[] {0, 1, 2}},
                {new int[] {0, 0, 1}, new int[] {0, 0, 1}},
                {new int[] {1, 0, 1}, new int[] {0, 1, 1}},
                {new int[] {1, 1, 0}, new int[] {0, 1, 1}},
                {new int[] {-2, 1, 0}, new int[] {-2, 0, 1}},
                {new int[] {0, 1, 1, 2}, new int[] {0, 1, 1, 2}},
                {new int[] {2, 1, 1, 0}, new int[] {0, 1, 1, 2}},
                {new int[] {1, 1, 2, 0}, new int[] {0, 1, 1, 2}},
                {new int[] {1, 1, 1, 1}, new int[] {1, 1, 1, 1}},
                {new int[] {1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1}},
        };
    }

    @Test(dataProvider = "sortDataProvider")
    public void testQuickSort(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.quickSort(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

    @Test(dataProvider = "sortDataProvider")
    public void testMergeSort(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.mergeSort(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

    @Test(dataProvider = "sortDataProvider")
    public void testBubbleSort(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.bubbleSort(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

    @Test(dataProvider = "sortDataProvider")
    public void testBubbleSort2(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.bubbleSort2(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

    @Test(dataProvider = "sortDataProvider")
    public void testSelectionSort(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.selectionSort(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

    @Test(dataProvider = "sortDataProvider")
    public void testInsertionSort(int[] unSorted, int[] sorted) {
        int[] workingCopy = Arrays.copyOf(unSorted, unSorted.length);
        Sorter sorter = new Sorter();
        sorter.insertionSort(workingCopy);
        Assert.assertArrayEquals(
                "For " + Arrays.toString(unSorted) + ", obtained " + Arrays.toString(workingCopy),
                workingCopy,
                sorted);
    }

}
