import java.util.Comparator;

/**
 * This is a comment!
 *
 * @class: WordSearch
 * @description: 79. Word Search
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 14:59
 **/
public class WordSearch {
    /*

    回溯+DFS，已经访问过的换为#，DFS后在换回来
     */
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (help(board, word, 0, i, j))
                    return true;
            }
        }
        return false;

    }

    private boolean help(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (board[i][j] == word.charAt(index)) {
            char copy = board[i][j];
            board[i][j] = '$';
            boolean res = help(board, word, index + 1, i + 1, j)
                    || help(board, word, index + 1, i, j + 1)
                    || help(board, word, index + 1, i - 1, j)
                    || help(board, word, index + 1, i, j - 1);
            board[i][j] = copy;
            return res;
        }
        return false;
    }
}
