import java.util.*;
/**
 * 09/14/2022
 */
public class Duolingo_OA1 {
    /**
     * Counting Mistakes.
     */
    public List<String> countingMistakes(List<List<String>> submissions) {
        int n = submissions.get(0).size(), m = submissions.size();
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            temp = new HashMap<>();
            int bar = 0;
            for (int j = 0; j < m; j++) {
                String ans = submissions.get(j).get(i);
                int freq = temp.getOrDefault(ans, 0) + 1;
                temp.put(ans, freq);
                bar = Math.max(bar, freq);
            }
            for (String ans : temp.keySet()) {
                if (temp.get(ans) < bar) {
                    map.put(ans, map.getOrDefault(ans, 0) + temp.get(ans));
                }
            }
            temp.clear();
        }
//        // TLE:
//        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> (map.get(s1) == map.get(s2) ?
//                s1.compareTo(s2) : map.get(s2) - map.get(s1)));
//        for (String str : map.keySet()) {
//            pq.offer(str);
//        }
//        while (!pq.isEmpty()) {
//            res.add(pq.poll());
//        }
        int length = 0;
        for (int freq : map.values()) {
            length = Math.max(length, freq);
        }
        List<String>[] list = new List[length];
        for (int i = 0; i < length; i++) {
            list[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            list[e.getValue() - 1].add(e.getKey());
        }
        for (int i = length - 1; i >= 0; i--) {
            Collections.sort(list[i]);
            res.addAll(list[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Duolingo_OA1 solution = new Duolingo_OA1();
        List<List<String>> testList1 = new ArrayList<>();
        testList1.add(Arrays.asList(new String[]{"your", "bear", "drinks", "beer"}));
        testList1.add(Arrays.asList(new String[]{"your", "bear", "eats", "beer"}));
        testList1.add(Arrays.asList(new String[]{"the", "bear", "drinks", "beer"}));
        System.out.println(solution.countingMistakes(testList1));

        List<List<String>> testList2 = new ArrayList<>();
        testList2.add(Arrays.asList(new String[]{"your", "bear", "drinks", "beer"}));
        testList2.add(Arrays.asList(new String[]{"your", "bear", "eats", "beer"}));
        testList2.add(Arrays.asList(new String[]{"the", "bear", "drinks", "beer"}));
        testList2.add(Arrays.asList(new String[]{"your", "bear", "the", "beer"}));
        System.out.println(solution.countingMistakes(testList2));
    }

}
