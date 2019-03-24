public class RangeSumQuery2DMutable {

    public static void testWeird(int i, int j) {
        for (; i > 0; i -= i & -i) {
            for (; j > 0; j -= j & -j) {
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println("--------");
    }

    public static void testWeird2(int i, int j) {
        for (int k = i; k > 0; k -= k & -k) {
            for (int l = j; l > 0; l -= l & -l) {
                System.out.println("i = " + k + " j = " + l);
            }
        }
    }

    public static void main(String[] args) {
        testWeird(6,7);
       // testWeird2(6,7);
    }

}

class NumMatrix2 {
    int[][] nums;
    int[][] tree;

    //O(n*log(n)*m*log(m)

    public NumMatrix2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        this.nums = new int[matrix.length][matrix[0].length];
        this.tree = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }


    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        col++;
        row++;

        for (int i = row; i < tree.length; i += (i & -i)) {
            for (int j = col; j < tree[0].length; j += (j & -j)) {
                tree[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
    }

    private int sum(int i, int j) {
        int sum = 0;
        for (int m = i; m > 0; m -= (m & -m)) {
            for (int n = j; n > 0; n -= (n & -n)) {
                sum += tree[m][n];
            }
        }
        return sum;
    }
/*
5 4
4 4
5 1
4 1
2 4
2 1
5 4
4 4
5 1
4 1
2 4
2 1

5 4
5 1
2 4
2 1
5 4
5 1
2 4
2 1
 */

}