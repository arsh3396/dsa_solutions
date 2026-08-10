package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - take one extra matrix and put element according to need.
            - after that put them back to original matrix.
        TC: O(n x m)
        SC: O(n x m)

    Optimal:
        Idea:
            - first take transpose of the matrix.
            - after that rotate every row of the matrix.
        TC: O(n x m)
        SC: O(1)
 */

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int k = 0, l = matrix[i].length - 1;
            while(k < l) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][l];
                matrix[i][l] = temp;
                k++;
                l--;
            }
        }
    }
}
