/*
 * 
 * Test Cases:
 * 1. Row matrix
 * 2. Column matrix
 * 3. m = 2 or n = 2 matrix
 * 4. m == n > 2 square matrix
 * 5. m > n rectangle matrix
 * 6. m < n rectangle matrix
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int rowLimit = (int) rows / 2;
        int colLimit = (int) columns / 2;
        int row = rowStart;
        int col = colStart;
        boolean reverse = false;
        List<Integer> elements = new ArrayList<>();

        if (rows == 1) {
            for (int i = 0; i < columns; i++) {
                elements.add(matrix[0][i]);
            }
            return elements;
        } else if (columns == 1) {
            for (int i = 0; i < rows; i++) {
                elements.add(matrix[i][0]);
            }
            return elements;
        } else if (rows == 2 || columns == 2) {
            colLimit = 0;
            rowLimit = 1;
        } else if (columns == rows && rows % 2 == 0) {
            rows -= 1;
            columns -= 1;
            colLimit -= 1;
        } else if (rows > columns) {
            if (columns % 2 == 0) {
                colLimit -= 1;
            } else if (rows - columns > 1) {
                rowLimit += 1;
            }
        } else if (rows < columns) {
            int rowReduce = (int) rows / 2;
            int colReduce = (int) columns / 2;
            boolean parity1 = rows % 2 == 0;
            boolean parity2 = columns % 2 == 0;
            int diff = Math.abs(colReduce - rowReduce);
            if (!parity1 && !parity2) {
                colLimit += diff;
            } else if (!parity1 && parity2) {
                colLimit += diff;
                colLimit -= 1;
            } else {
                colLimit -= diff;
                colLimit -= 1;
            }
        }

        while (rowStart <= rowEnd && colStart <= colEnd) {
            elements.add(matrix[row][col]);
            if (row == rowLimit && col == colLimit)
                break;
            if (!reverse) {
                if (col < colEnd) {
                    col += 1;
                } else if (row < rowEnd) {
                    row += 1;
                } else {
                    reverse = true;
                    col -= 1;
                }
            } else {
                if (col > colStart) {
                    col -= 1;
                } else if (row > rowStart + 1) {
                    row -= 1;
                } else {
                    reverse = false;
                    rowStart += 1;
                    colStart += 1;
                    rowEnd -= 1;
                    colEnd -= 1;
                    row = rowStart;
                    col = colStart;
                }
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
        scan.close();
    }

}
