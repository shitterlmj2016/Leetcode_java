public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'k')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X' || board[i][j] == 'k')
            return;
        board[i][j] = 'k';

        if (i > 0)
            dfs(board, i - 1, j);
        if (i < board.length - 1)
            dfs(board, i + 1, j);
        if (j > 0)
            dfs(board, i, j - 1);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1);
    }
}
