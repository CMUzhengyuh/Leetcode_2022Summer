import java.util.*;

public class _Consumer_Revenue_ {

    private Map<Integer, Integer> map;

    private int id;

    private Map<Integer, Integer> graph;

    private TreeMap<Integer, Set<Integer>> revMap;

    public _Consumer_Revenue_() {
        this.map = new HashMap<>();
        this.id = 0;
        this.graph = new HashMap<>();
        this.revMap = new TreeMap<>();
    }

    public int insert(int revenue) {
        map.put(id, revenue);
        revMap.putIfAbsent(revenue, new HashSet<>());
        revMap.get(revenue).add(id);
        return id++;
    }

    public int insert(int revenue, int referrerID, int level) {
        int newId = insert(revenue);
        graph.put(newId, referrerID);
        update(referrerID, level, revenue);
        return newId;
    }

    private void update(int curId, int level, int revenue) {
        if (level == 0) {
            return;
        }
        if (map.containsKey(curId)) {
            int prevRev = map.get(curId);
            revMap.get(prevRev).remove(curId);
            int newRev = prevRev + revenue;
            revMap.putIfAbsent(newRev, new HashSet<>());
            revMap.get(newRev).add(curId);
            map.put(curId, newRev);
        }
        if (graph.containsKey(curId)) {
            update(graph.get(curId), level - 1, revenue);
        }
    }

    public List<Integer> getKLowestRevenue(int k, int targetRevenue) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> tailMap = revMap.tailMap(targetRevenue, false);
        for (Set<Integer> set : tailMap.values()) {
            if (set.size() <= k) {
                res.addAll(set);
                k -= set.size();
            } else {
                Iterator<Integer> it = set.iterator();
                while (k-- > 0) {
                    res.add(it.next());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _Consumer_Revenue_ revenue = new _Consumer_Revenue_();
        revenue.insert(10);                         // 0 -> 10
        revenue.insert(20);                         // 1 -> 20
        revenue.insert(30, 1, 2);    // 2 -> 30 1 -> 50
        revenue.insert(10, 1, 3);    // 3 -> 10 1 -> 60
        revenue.insert(10, 2, 2);    // 4 -> 10 2 -> 40
        /*
        0               10
        1               20 + 30 + 10 + 10 = 70
        2 -> 1          30 + 10 = 40
        3 -> 1          10
        4 -> 2 -> 1     10
         */
        System.out.println(revenue.map);
        System.out.println(revenue.graph);
        System.out.println(revenue.revMap);

        System.out.println(revenue.getKLowestRevenue(3, 0));
    }
}
