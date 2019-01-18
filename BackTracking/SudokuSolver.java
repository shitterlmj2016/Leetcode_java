/**
 * This is a comment!
 *
 * @class: SudokuSolver
 * @description: 37. Sudoku Solver
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 21:02
 **/
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        System.out.println(1);
        if (board == null || board.length == 0)
            return;

        solve(board);
        System.out.println(1);
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) { //这里是1 不是0
                        if (isValid(i, j, k,board)) {
                            board[i][j] = k;
                            if (solve(board))
                                return true; //有空位且找到符合空位的数
                            board[i][j] = '.';
                        }
                    }
                    return false;
                    //有空位但没有符合空位的数，return false
                }
            }
        }
        //没有空位，已经走到最底层
        return true;
    }

    private boolean isValid(int i, int j, char k,char[][] board) {
        for (int l = 0; l <9 ; l++) {
            if(board[i][l]!='.'&&board[i][l]==k)
                return false;
            if(board[l][j]!='.'&&board[l][j]==k)
                return false;

            // 0 0 0
            //重点， i，j决定九宫格位置，l觉得九宫格里面哪一个
            int row = 3*(i/3)+ l%3;
            int col = 3*(j/3)+ l/3;
            if(board[row][col]!='.'&&board[row][col] == k)
                return false;
        }
        return true;


    }


    public static void main(String[] args) {
        char a [][] ={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver s = new SudokuSolver();

        s.solveSudoku(a);
    }


}
