/**
 * This is a comment!
 *
 * @class: Searcha2DMatrixII
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 02-25-2019 10:33
 **/
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null
                || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int len = matrix[0].length;
        int lo = 0;
        int hi = matrix.length - 1;
        int mid = (hi - lo) / 2;
        while (lo < hi) {
            mid = (hi - lo) / 2 + lo;
            if (matrix[mid][len - 1] < target) {
                lo = mid + 1;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else break;
        }

        System.out.println(mid);
        return true;
    }
}
