package com.training;

import com.sun.javafx.binding.StringFormatter;

/**
 * This class is to solve factorial numbers.
 * Given a non-negative number n find its factorial without using Recursion.
 * n! = 1 * 2 * 3 * 4 * ...... n-2 * n-1 * n
 * Also, implement using a recursive method. Factorial can also be recursively expressed as
 * factorial(n) = n * factorial(n - 1)
 * This is definitely a very trivial exercise. But the exercise is deliberately kept trivial so that one can concentrate
 * on other important aspects of the art of coding which are listed below.
 * <p>
 * 1. Check for illegal arguments and handle them
 * 2. Inline comments
 * 3. JavaDoc for the class
 * 4. JavaDoc for all the public methods
 * 5. Ability to convert a recursive method into a non-recursive method.
 *
 * @author mingluma
 */
public class Factorial {
    /**
     * Using recursion method to get factorial number
     *
     * @param n
     * @return nth factorial number, invalid input return -1
     */
    public int factorialUsingRecursion(int n) {
        // check input
        if (n < 0 || n > 12) {
            return -1;
        } else if (n < 2) {
            return n;
        } else {
            return factorialUsingRecursion(n - 1) * n;
        }
    }

    /**
     * Using no recursion method to get factorial number
     *
     * @param n
     * @return nth factorial number
     * @throws IllegalArgumentException when input is not valid
     */
    public int factorial(int n) {
        // check input
        isValid(n);
        if (n < 2) return n;
        int result = 1;
        int i = n;
        while (i > 0) {
            result *= i;
            i--;
        }
        return result;
    }

    /**
     * Check input is valid or not.
     */
    private void isValid(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative number.");
        } else if (n > 12) {
            throw new IllegalArgumentException("Input should be smaller than 13.");
        }
    }

}
