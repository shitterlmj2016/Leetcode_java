/**
 * @program: Leetcode_java
 * @description: 311. Sparse Matrix Multiplication
 * @author: Xincheng Huang
 * @create: 2019-03-23 21:02
 **/

public class SparseMatrixMultiplication {
    /*
Output:

     |  1 0 0 |   | 7 0 0 1|   |  7 0 0  1 |
AB = | -1 0 3 | x | 0 0 0 1| = | -7 0 3 -1|
                  | 0 0 1 1|

     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int b = B[0].length;
        int[][] res = new int[m][b];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b; j++) {//注意以结果矩阵为外循环，公共有的长度为最内循环
                for (int k = 0; k < n; k++) {
                    if (A[i][k] != 0 && B[k][j] != 0)
                        res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
