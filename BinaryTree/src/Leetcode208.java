/**
 * 06/19/2022
 */
public class Leetcode208 {
    /**
     * Leetcode 208 - Implement Trie (Prefix Tree) (Medium)
     * Trie data structure aims to solve fast search and match string problem.
     * TrieNode composes of three private fields:
     * (1) Boolean field indicates whether the path from root forms a word.
     * (2) Character field represents current position.
     * (3) List TrieNode field records parent-child relations.
     * Three functions in Trie Class share similar ideas:
     * (1) Start from root node and search for next character.
     * (2) If cannot find according to the input string, then add the branch
     *     for insert() and return false for search() or startWith().
     * (3) If the input string matches, then set the boolean field true for
     *     insert(), return the boolean field for search() and return true for
     *     startWith().
     */
    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }

        class TrieNode {

            public boolean isWord;

            public char val;

            private TrieNode[] children = new TrieNode[26];

            public TrieNode() {}

            TrieNode(char c) {
                TrieNode node = new TrieNode();
                node.val = c;
            }
        }
    }
}
