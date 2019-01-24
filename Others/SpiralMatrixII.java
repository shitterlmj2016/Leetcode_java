/**
 * This is a comment!
 *
 * @class: SpiralMatrixII
 * @description: 59. Spiral Matrix II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 21:07
 **/
public class SpiralMatrixII {


    //千万要注意，边界不是大于等于0，是大于等于up和left！！！！
    public static int[][] generateMatrix(int n) {
        if (n <= 0)
            return null;

        int[][] res = new int[n][n];

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
/*
[ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 */
        int a = 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res[up][i] = a++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = a++;
            }
            right--;
            if (left <= right && up <= down) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = a++;
                }
            }
            down--;
            if (left <= right && up <= down) {
                for (int i = down; i >= up; i--) {
                    res[i][left] = a++;
                }
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
