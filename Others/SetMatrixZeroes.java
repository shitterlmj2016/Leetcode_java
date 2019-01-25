/**
 * This is a comment!
 *
 * @class: SetMatrixZeroes
 * @description: 73. Set Matrix Zeroes
 * @author: Xincheng Huang - xinchenh
 * @create: 01-24-2019 22:47
 **/
public class SetMatrixZeroes {
    /*
    技巧很多，需要复习
     */

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0)
                        row = true;
                    if (j == 0)
                        col = true;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
