/**
 * This is a comment!
 *
 * @class: BattleshipsinaBoard
 * @description: 419. Battleships in a Board
 * @author: Xincheng Huang - xinchenh
 * @create: 01-20-2019 23:45
 **/
public class BattleshipsinaBoard {

    /**
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;


        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    res++;
                    help(board, i, j);
                }
            }
        }
        return res;
    }

    private void help(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X')
            return;

        board[i][j] = '.';
        help(board, i - 1, j);
        help(board, i + 1, j);
        help(board, i, j - 1);
        help(board, i, j + 1);
    }


}
