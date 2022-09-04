import java.util.*;
/**
 * 06/19/2022 *** Not solved
 */
public class Leetcode212 {
    /**
     * Leetcode 212 - Unique Binary Search Trees (Medium)
     * TC: ?
     * SC: ?
     * Possible solution.
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS (board, i, j, root, res);
            }
        }
        return res;
    }

    public void DFS(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {   // found one
            res.add(node.word);
            node.word = null;     // de-duplicate
        }
        board[i][j] = '#';
        if (i > 0) DFS(board, i - 1, j ,node, res);
        if (j > 0) DFS(board, i, j - 1, node, res);
        if (i < board.length - 1) DFS(board, i + 1, j, node, res);
        if (j < board[0].length - 1) DFS(board, i, j + 1, node, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.next[i] == null) cur.next[i] = new TrieNode();
                cur = cur.next[i];
            }
            cur.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
