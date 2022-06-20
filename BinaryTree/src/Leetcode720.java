/**
 * 06/19/2022
 */
public class Leetcode720 {

    private String res = "";

    private TrieNode root;

    /**
     * Leetcode 720 - Longest Word in Dictionary (Medium)
     * TC: O(n)
     * SC: O(n)
     * Sequentially add words to Trie and depth first search for result.
     * The value field of TrieNode changes to String to simplify the design.
     * The key point of depth first search is to guarantee that only one
     * character is added at a time from one existing word to another.
     */
    public String longestWord(String[] words) {
        root = new TrieNode();
        for (String s : words) {
            insert(s);
        }
        DFS(root);
        return res;
    }

    private void DFS(TrieNode cur) {
        if (cur == null) return;
        if (cur.val != null) {
            if (cur.val.length() > res.length()) res = cur.val;
            else if (cur.val.length() == res.length() && cur.val.compareTo(res) < 0) res = cur.val;

        }
        for (TrieNode temp : cur.children) {
            if (temp != null && temp.val != null) DFS(temp);
        }
    }


    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.val = word;
    }

    class TrieNode {

        public String val;

        private TrieNode[] children = new TrieNode[26];

        public TrieNode() {}

    }
}