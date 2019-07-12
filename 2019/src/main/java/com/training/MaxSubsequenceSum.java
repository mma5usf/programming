package com.training;

/**
 * Maximum Subsequence Sum is one of the classic problems found in the Data Structures & Algoritms books.
 *
 * Given a one dimensional array of integers the task is to find a contiguous subarray with the largest sum.
 *
 * -1 -3 5 -2 -1 3 1 -2
 *
 * For the above array the MaxSubsequenceSum is 6 which is obtained by starting from the 3rd element which is 5
 * and upto the last but one element which is 1.
 *
 * 5 + (-2) + (-1) + 3 + 1 = 6
 *
 * This exercise also is not that difficult. Just to spice up the exercise please implement the naive or
 * brute force solution also. Divide and Conquer strategy also can be used and you can optionally implement
 * that solution also.
 */
public class MaxSubsequenceSum {

    /**
     * Use DP to find max subsequence sum
     * @param anInput input integer array
     * @return max subsequence sum
     * @exception IllegalArgumentException if input is null or empty
     */
    public int findMaxSubsequenceSum(int[] anInput){
        if(anInput == null || anInput.length < 1) {
            throw new IllegalArgumentException("Input array can't be empty");
        }
        int result = anInput[0];
        int cur = anInput[0];
        for (int i = 1; i < anInput.length; i++) {
            // update cur to max value of sub array ending at index i
            cur = Math.max(cur + anInput[i], anInput[i]);
            // update result to current max value
            result = Math.max(result, cur);
        }
        return result;
    }

    /**
     * Use Brute Force to find max subsequence sum
     * @param anInput input integer array
     * @return max subsequence sum
     * @exception IllegalArgumentException if input is null or empty
     */
    public int findMaxSubsequenceSumUsingBruteForce(int[] anInput){
        if(anInput == null || anInput.length < 1) {
            throw new IllegalArgumentException("Input array can't be empty");
        }
        int result = Integer.MIN_VALUE;
        int len = anInput.length;
        for(int i = 0; i < len; i++) {
            int curSum = 0;
            for (int j = i; j < len; j++) {
                curSum += anInput[j];
                if (curSum > result)
                    result = curSum;
            }
        }
        return result;
    }

    //public int findMaxSubsequenceSumUsingDivideAndConquer(int[] anInput);

}
