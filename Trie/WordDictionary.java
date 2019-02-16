/**
 * This is a comment!
 *
 * @class: AddandSearchWord
 * @description: Add and Search Word - Data structure design
 * @author: Xincheng Huang - xinchenh
 * @create: 02-14-2019 23:41
 **/
public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    /**
     * Initialize your data structure here.
     */

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (curr.children[j] == null) {
                curr.children[j] = new TrieNode();
            }
            curr = curr.children[j];
        }
        curr.isWord = true;
        curr.word = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        return helper(root, word, 0);
    }

    private boolean helper(TrieNode node, String s, int start) {
        if (start == s.length()) {
            return node.isWord;
        }
        char c = s.charAt(start);
        if (c == '.') {
            for (TrieNode child : node.children
            ) {
                if (child != null && helper(child, s, start + 1))
                    return true;
            }
            return false;
        } else return node.children[c - 'a'] == null ? false : helper(node.children[c - 'a'], s, start++);//+1,++是错的
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        System.out.println(wd.search(".mad"));

    }
}
