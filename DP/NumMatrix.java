public class NumMatrix {

    private int[][] sum;
    private boolean isEmpty = false;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix.length == 0) {
            isEmpty = true;
            return;
        }
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isEmpty)
            return 0;
        return sum[row1][col1] + sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1];
    }
}
