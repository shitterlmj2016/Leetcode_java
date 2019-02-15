/**
 * This is a comment!
 *
 * @class: ImplementTrie
 * @description: Implement Trie (Prefix Tree)
 * @author: Xincheng Huang - xinchenh
 * @create: 02-14-2019 23:39
 **/
public class Trie {
    /**
     * Initialize your data structure here。
     */
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }


    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return curr.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        if (curr.isWord)
            return true;
        for (TrieNode node : curr.children
        ) {
            if (node != null)
                return true;
        }
        return false;
    }
}
