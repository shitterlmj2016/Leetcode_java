import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if (board[i][j] == '.' || node.children[c - 'a'] == null)
            return;
        TrieNode child = node.children[c - 'a'];
        if (child.word != null) {
            res.add(child.word);
            child.word = null;//去重
        }

        board[i][j] = '.';

        if (child != null) {
            dfs(board, i - 1, j, child, res);
            dfs(board, i + 1, j, child, res);
            dfs(board, i, j - 1, child, res);
            dfs(board, i, j + 1, child, res);
        }

        board[i][j] = c;
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words
        ) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return root;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

}
