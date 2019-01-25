/**
 * This is a comment!
 *
 * @class: Searcha2DMatrix
 * @description: 74. Search a 2D Matrix
 * @author: Xincheng Huang - xinchenh
 * @create: 01-24-2019 23:17
 **/
public class Searcha2DMatrix {
    //双重二分
    /*
    matrix = [
      [1,   3,  5,  7],

      [10, 11, 16, 20],

      [23, 30, 34, 50]
    ]
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m - 1;
        int mid = (hi - lo) / 2 + lo;
        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;
            if (matrix[mid][n - 1] < target)
                lo = mid + 1;
            else if (matrix[mid][0] > target)
                hi = mid - 1;
            else break;
        }

        lo = 0;
        hi = n - 1;

        while (lo <= hi) {
            int t = (hi - lo) / 2 + lo;
            if (matrix[mid][t] < target)
                lo = t + 1;
            else if (matrix[mid][t] > target)
                hi = t - 1;
            else return true;
        }

        return false;
    }


}
