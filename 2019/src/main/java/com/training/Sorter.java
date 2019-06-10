package com.training;


public class Sorter {
    /** Bubble Sort
     * Stable
     * Worst case and average time O(n * n), but often O(nlogn)
    * @param array
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void bubbleSort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        boolean swapped;
        for (int i = 0; i < len - 1; i++) {
            swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // if inner loop is not swapped any, just break out.
            if(!swapped) {
                break;
            }
        }
    }

    /** Selection Sort
     * It is not stable for this array swap solution.
     * O(n * n)
     * @param array
     */
    public void selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }


    /** Insertion Sort
     * O (n * n)
     * Stable
     * @param array
     */
    public void insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for(int i = 1; i < len; i++) {
            int cur = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > cur){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = cur;
        }
    }



    /** Quick Sort
     * Notes: Time O(nlogn) average,
     * but the worst case is O(n^2) when the pivot always the largest or smallest one in the rest of array.
     * Space O(1)
     * Quicksort is not a stable sort, meaning that the relative order of equal sort items is not preserved.
     * @param array input integer array to sort.
     */
    void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end -1;
        while(i <= j) {
            if( array[i] < array[end]) { // Todo: refactor. Use the end one as the pivot is not good.
                i++;
            } else if (array[j] >= array[end]) {
                j--;
            } else {
                swap(array, i++,  j--); // Don’t forget update pointers
            }
        }
        swap(array, i, end);  // when out of while loop, i is the first one => pivot
        quickSort(array, 0, i - 1);
        quickSort(array, i + 1, end);
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    // Merge Sort
    public int[] mergeSort(int[] array) {
        if(array == null || array.length == 1) {
            return array;
        }
        int[] tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1, tmp);
        return array;
    }

    private void mergeSort(int[] array, int left, int right, int[] tmp) {
        if(left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(array, left, mid, tmp);
        mergeSort(array, mid+1, right, tmp);
        merge(array, left, mid, right, tmp);
    }

    private void merge(int[] array, int left, int mid, int right, int[] tmp) {
        if (right + 1 >= 0) System.arraycopy(array, 0, tmp, 0, right + 1);
        int leftp = left;
        int rightp = mid + 1;
        while (leftp <= mid && rightp <= right) {
            if (tmp[leftp] <= tmp[rightp]){
                array[left++] = tmp[leftp++];
            } else {
                array[left++] = tmp[rightp++];
            }
        }
        while (leftp <= mid) { // move the left in the left side, but the right side don’t need to.
            array[left++] = tmp[leftp++];
        }
    }


}