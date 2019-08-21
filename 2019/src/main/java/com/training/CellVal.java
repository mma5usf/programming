package com.training;

import java.util.ArrayList;
import java.util.List;

/**
 * CellVal(RowNum, ColNum) = CellVal(RowNum - 1, ColNum - 1) + CellVal(RowNum - 1, ColNum + 1)
 */
public class CellVal {
    /**
     * Generate the pascals triangle and return the nRowNum, nColNum one.
     * @param nRowNum the index of row
     * @param nColNum the index of column
     * @return the number in nRowNum & nColNum, if
     */
    public int getCellVall(int nRowNum, int nColNum) {
        if (nRowNum < 1 || nRowNum < nColNum) {
            throw new IllegalArgumentException(
                "nRowNum must be a positive number and larger or equal than nColNum");
        }
        if (nColNum == 1) {
            return 1;
        }
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i <= nRowNum; i++) {
            row.add(0, 1); // always add one at the begin of row
            for (int j = 1; j < row.size() - 1; j++) {
                if (i == nRowNum - 1 && j == nColNum - 1) {
                    return row.get(j) + row.get(j + 1);
                } else {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
            }
            triangle.add(new ArrayList(row));
            //System.out.println(triangle);
        }
        return -1;
    }

}
