/**
 * This is a comment!
 *
 * @class: UniquePaths
 * @description: 62. Unique Paths
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 22:47
 **/
// t: O(m*n) S; O(m*n)
//非常基础
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }


    public int uniquePaths2(int m, int n) {
        //逐行扫描 更优
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];// res[j] 上面的往下走 res[j-1]左边的往右走
            }
        }

        return res[n - 1];

    }


    //一共走到步数 m+n-2
    //排列组合 m-1 步往右走 n-1步往下走
    //   m-1
    // C m+n-2  = (m+n-2)!/(m-1)!(n-1)! = (m*m+1*m+2...*m+n-2)/(n-1)!
    public int uniquePaths3(int m, int n) {
        //逐行扫描 更优
        int a = m + n - 2;
        int b = n - 1;
        double res = 1; //要设置为double，保留小数
        for (int i = 1; i <= b; i++) {
            res = res* (a - b + i) / i;
        }
        return (int)res;
    }
}
