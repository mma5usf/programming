package com.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Eight Queens
 * The eight queens problem is the problem of placing eight queens on a 8×8 chessboard
 * such that none of them attack one another (no two are in the same row, column, or diagonal).
 *
 * When the solve() method is called it should print all possible unique solutions,
 * printing each solution in a line and finally should print the Total number of solutions.
 *
 * As an example one possible solution could be
 * 15863724
 *
 * There are eight numbers printed, each digit giving the column number and the position of
 * the digit is the row number.
 *
 * So in the above example, in 1st row, 1st column a queen is placed, then in 2nd row, 5th column,
 * then in 3rd row 8th column and so on.
 *
 * Implement the class EightQueens
 * public void solve();
 */
public class EightQueens {

    // Generalize question. Give size n, and the board is n * n.
    public List<List<Integer>> solve(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        nqueens(n, cur, result);
        return result;
    }

    private void nqueens(int n, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                cur.add(i);
                nqueens(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> cur, int col) {
        int row = cur.size();
        for (int i = 0;  i < row; i++) {
            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}
