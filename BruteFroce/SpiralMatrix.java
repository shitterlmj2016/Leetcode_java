import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: SpiralMatrix
 * @description: 54. Spiral Matrix
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 21:55
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;

        /*
        1 2 3 4
        2 3 4 5
        1 6 5 6
        0 9 8 7
         */
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length - 1;
//循环中不断改变左右上下边界！
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i <= colMax; i++) {
                res.add(matrix[rowMin][i]);
            }
            rowMin++;
            for (int i = rowMin; i <= rowMax; i++) {
                res.add(matrix[i][colMax]);
            }
            colMax--;
            if (rowMax >= rowMin) { //注意这里因为变动了，随意要检查
                for (int i = colMax; i >= colMin; i--) {
                    res.add(matrix[rowMax][i]);
                }
            }
            rowMax--;
            if (colMax >= colMin) {//注意这里因为变动了，随意要检查
                for (int i = rowMax; i >= rowMin; i--)
                    res.add(matrix[colMin][i]);
            }
            colMin++;


        }


        return res;
    }

}
