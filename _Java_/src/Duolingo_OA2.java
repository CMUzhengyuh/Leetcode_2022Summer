import java.util.*;
/**
 * 09/14/2022
 */
public class Duolingo_OA2 {
    /**
     * Mazes.
     */
    public List<String> mazes(List<String> path) {
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        String[] word = new String[]{"south", "north", "east", "west"};
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int x = 0, y = 0;
        String endSign = x + "." + y;
        map.put(endSign, new ArrayList<>());
        set.add(endSign);
        q.add(endSign);
        for (String dir : path) {
            switch (dir) {
                case "south":
                    y--;
                    break;
                case "north":
                    y++;
                    break;
                case "east":
                    x++;
                    break;
                case "west":
                    x--;
                    break;
            }
            endSign = x + "." + y;
            map.put(endSign, new ArrayList<>());
            set.add(endSign);
        }

        x = 0;
        y = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String cur = q.poll();
                int[] a = strToArray(cur);
                x = a[0];
                y = a[1];
                if (cur.equals(endSign)) {
                    return map.get(cur);
                }
                set.remove(cur);
                for (int d = 0; d < 4; d++) {
                    int i = x + dirs[d][0], j = y + dirs[d][1];
                    String next = i + "." + j;
                    if (set.contains(next)) {
                        map.put(next, new ArrayList<>(map.get(cur)));
                        map.get(next).add(word[d]);
                        q.add(next);
                    }
                }
            }
        }
        return res;
    }

    private int[] strToArray(String str) {
        int[] res = new int[2];
        String[] a = str.split("\\.");
        res[0] = Integer.parseInt(a[0]);
        res[1] = Integer.parseInt(a[1]);
        return res;
    }

    public static void main(String[] args) {
        Duolingo_OA2 solution = new Duolingo_OA2();
        List<String> path1 = Arrays.asList(new String[]{
                "south", "south", "south", "south",
                "east", "north", "east", "south",
                "east", "north", "north", "east"
        });
        System.out.println(solution.mazes(path1));

        List<String> path2 = Arrays.asList(new String[]{
                "south", "south", "south", "east",
                "east", "east", "east", "east",
                "south", "south", "west", "west",
                "west", "west", "west", "south",
                "south", "east", "east", "north",
                "north", "east", "east", "east",
                "north", "north", "west", "west",
                "west", "west", "west", "north",
                "north", "east", "east", "east",
                "east", "east", "east", "east",
                "south", "south", "south", "south",
                "south", "south", "south", "south",
        });
        System.out.println(solution.mazes(path2));
    }
}
