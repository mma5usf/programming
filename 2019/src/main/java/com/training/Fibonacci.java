package com.training;

/**
 * Given a non-negative number n find the nth Fibonacci Number. The Fibonacci Sequence is the series
 * of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... The 0th number is 0. 1st number is 1. Thereafter
 * every number is derived by adding two numbers before it.
 *
 * Fib(0) = 0 Fib(1) = 1 Fib(n) = Fib(n-1) + Fib(n-2)
 *
 * As part of this exercise first find the Fibonacci number without using recursion and then using
 * recursion. Please note that the recursive implementation makes two recursive calls.
 *
 * @author mingluma
 */
public class Fibonacci {

    /**
     * Compute nth Fibonacci number without recursive calls
     *
     * @param n non-negative input, the nth Fibonacci number to calculate
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if input is negative
     */
    public long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative number.");
        } else if (n < 2) {
            return n;
        }
        int fib1 = 1; //fib(n - 1)
        int fib2 = 0; //fib(n - 2)
        while (n > 1) {
            fib1 += fib2;
            fib2 = fib1 - fib2;
            n--;
        }
        return fib1;
    }

    /**
     * Compute nth Fibonacci number with O(n) space
     *
     * @param n non-negative input, the nth Fibonacci number to calculate
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if input is negative
     */
    public long fibWithSpace(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative number.");
        }
        if (n < 2) {
            return n;
        }
        long[] array = new long[n + 1];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];

    }

    /**
     * Compute nth Fibonacci number with Double Recursion
     *
     * @param n non-negative input, the nth Fibonacci number to calculate
     * @return if the input is valid return the nth Fibonacci number, else return 0
     */
    public long fibUsingDoubleRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return n;
        }
        return fibUsingDoubleRecursion(n - 1) + fibUsingDoubleRecursion(n - 2);
    }

    /**
     * Compute nth Fibonacci number with Single Recursion
     *
     * @param n non-negative input, the nth Fibonacci number to calculate
     * @return if the input is valid return the nth Fibonacci number, else return 0
     */
    public long fibUsingSingleRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return n;
        }
        // already have fib(0), fib(1) as base case
        return fibUsingSingleRecursion(n - 2, 1, 0);
    }

    /**
     * Helper method to compute fib(n) with fib(n-1) and fib(n - 2)
     *
     * @param n The number of layers need to be compute
     * @param fib1 fib(n - 1)
     * @param fib2 fib(n - 2)
     * @return if the input is valid return the nth Fibonacci number, else return 0
     */
    private long fibUsingSingleRecursion(int n, int fib1, int fib2) {
        if (n < 0) {
            return fib1;
        }
        return fibUsingSingleRecursion(n - 1, fib1 + fib2, fib1);
    }

}
