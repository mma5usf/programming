package com.training;

import java.util.Arrays;

/**
 * Given an array of integers, rotate the array by the specified number of times.
 * If the rotation count is 1, then all the elements are shifted right once and
 * the last element of the array occupies the first position.
 * For example 1 2 3 4 5 - > 4 5 1 2 3, when rotation count is 2
 *
 *
 * Notes: It is the same idea as "I love yahoo" -> "yahoo love I"
 */
public class ArrayRotation {

    /**
     * Rotate array to right by the nRotationCount
     * @param array input array
     * @param nRotationCount rotation count
     */
    public static void rotateArray(int[] array, int nRotationCount) {
        if (array == null || array.length <= 0 || nRotationCount <= 0) {
            return;
        }
        int len = array.length;
        int count = nRotationCount % len;
        rotate(array, len - count, len - 1);
        rotate(array, 0, len - count - 1);
        rotate(array, 0, len - 1);
    }

    private static void rotate(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArray(array, 5);
        System.out.println(Arrays.toString(array));
    }


}
