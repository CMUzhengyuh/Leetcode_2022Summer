import java.util.*;
/**
 * 09/13/2022
 */
public class Leetcode127 {

    private char[][] wordMap = new char[0][0];
    /**
     * Leetcode 127 - Word Ladder (Hard)
     * TC: O(n ^ 2)
     * SC: O(n ^ 2)
     * (1) Add the begin word into the wordList and utilize a map to store the
     *     string -> index of string that has difference = 1 mapping.
     * (2) Breadth first search from the begin word and traverse all unvisited
     *     adjacent strings until reaching the end word.
     * (3) If reaching the end word, return the level + 1 of given string and
     *     if begin word has no adjacent string or end word is not in the map,
     *     return 0.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<Integer>> map = new HashMap<>();
        wordMap = new char[wordList.size()][beginWord.length()];
        boolean containEnd = false;
        for (int i = 0; i < wordList.size(); i++) {
            wordMap[i] = wordList.get(i).toCharArray();
            if (wordList.get(i).equals(endWord)) {
                containEnd = true;
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (diff(i, j) == 1) {
                    map.putIfAbsent(wordList.get(i), new ArrayList<>());
                    map.get(wordList.get(i)).add(j);
                }
            }
        }
        if (!map.containsKey(beginWord) || !containEnd) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int level = 0;
        q.add(beginWord);
        set.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                for (int index : map.get(cur)) {
                    String word = wordList.get(index);
                    if (!set.contains(word))
                        q.add(word);
                    set.add(word);
                }
            }
        }
        return 0;

    }

    private int diff(int i, int j) {
        if (i == j) {
            return 0;
        }
        int res = 0;
        for (int k = 0; k < wordMap[0].length; k++) {
            if (wordMap[i][k] != wordMap[j][k]) {
                res++;
            }
        }
        return res;
    }
}
