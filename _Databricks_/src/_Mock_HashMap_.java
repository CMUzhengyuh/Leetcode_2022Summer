import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _Mock_HashMap_ {

    private Map<Integer, Integer> map;

    private TreeMap<Long, Integer> putCount, getCount;

    public _Mock_HashMap_() {
        this.map = new HashMap<>();
        this.getCount = new TreeMap<>();
        this.putCount = new TreeMap<>();
    }

    /**
     * Put API and update put() request time.
     */
    public void put(int key, int val) {
        map.put(key, val);
        long time = getTime();
        putCount.put(time, putCount.getOrDefault(time, 0) + 1);

    }

    /**
     * Get API and update get() request time.
     */
    public int get(int key) {
        int val = map.getOrDefault(key, -1);
        long time = getTime();
        getCount.put(time, getCount.getOrDefault(time, 0) + 1);
        return val;
    }

    /**
     * Retrieve total put() requests within 5min.
     */
    public int measurePutLoad() {
        long curTime = getTime();
        long startTime = curTime - (5 * 60 * 1000);
        int load = 0;
        for (int val : putCount.tailMap(startTime).values()) {
            load += val;
        }
        return load;
    }

    /**
     * Retrieve total get() requests within 5min.
     */
    public int measureGetLoad() {
        long curTime = getTime();
        long startTime = curTime - (5 * 60 * 1000);
        int load = 0;
        for (int val : getCount.tailMap(startTime).values()) {
            load += val;
        }
        return load;
    }

    /**
     * Helper function to fetch current time (in ms).
     */
    private long getTime() {
        return System.currentTimeMillis();
    }
}
