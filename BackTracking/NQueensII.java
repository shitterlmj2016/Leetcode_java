/**
 * This is a comment!
 *
 * @class: NQueensII
 * @description: 52. N-Queens II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 21:16
 **/
public class NQueensII {

    //比1简单，只需返回有多少种
    // boolean 矩阵的算法来做
    int res = 0;

    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[n * 2];
        boolean[] d2 = new boolean[n * 2];
        help(col, d1, d2, 0);
        return res;
    }

    private void help(boolean[] cols, boolean[] d1, boolean[] d2, int row) {
        int n = cols.length;
        if(row == n)
        {
            res++;
            return;
        }

        /*
        0,0  0,1  0,2  0,3
        1,0  1,1  1,2  1,3
        2,0  2,1  2,2  2,3
        3,0  3,1  3,2  3,3
         */

        for (int col = 0; col <cols.length ; col++) {
            int id1 =col-row+n; //左上到右下
            int id2 =col+row;

            if(!cols[col]&&!d1[id1]&&!d2[id2])
            {
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;  //判断这个位置能不能用
                help(cols,d1,d2,row+1);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
