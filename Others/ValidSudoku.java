import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: ValidSudoku
 * @description: 36. Valid Sudoku
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 20:01
 **/

/*
判断横，竖，九宫格
hashset中重复加会返回false
难点是3*3的cell 和 i,j的转化 需要在一个循环中判断
时间为 9*9
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {


        for (int i = 0; i < 9; i++) {
            //hash应该放在这里，每次要重置
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cell = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !row.add(board[i][j]))//第一横行
                    return false;
             //   System.out.println(1);
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
              //  System.out.println(2);
                //难点！！ cell坐标转换
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                // 0 0 | 0 3 | 0 6
               // System.out.println(3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
                        && !cell.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
               // System.out.println(4);
            }

        }
        return true;

    }


    //另外一种方法每个元素判断每一行每一列有没有和他重复的 空间小
}
