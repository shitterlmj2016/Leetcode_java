import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: NQueens
 * @description: 51. N-Queens
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 20:37
 **/
public class NQueens {
    //核心思想 把Queens表示为一位数组，代表每一列queen横坐标的位置
    //在对角线上：line.55 abs相减
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        if (n <= 0)
            return res;
        help(res, new int[n], 0);
        return res;
    }

    private void help(List<List<String>> res, int[] queens, int step) {
        if (step == queens.length)
            addList(res, queens);
        else
            for (int i = 0; i < queens.length; i++) {
                queens[step] = i;
                if (check(queens, step))
                    help(res, queens, step + 1);
            }
    }

    private void addList(List<List<String>> res, int[] queens) {
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (j == queens[i])
                    sb.append('Q');
                else
                    sb.append('.');
            }
            l.add(sb.toString());
        }

        res.add(l);
    }

    private boolean check(int[] queens, int step) {
        for (int i = 0; i < step; i++) {
            if (queens[i] == queens[step]) // 是否在同一列
                return false;
            if (Math.abs(queens[i] - queens[step]) == Math.abs(i - step)) //判断是否在同一对角线上
                return false;
        }
        return true;
    }


}
