import java.util.TreeMap;
/**
 * Leetcode 1146.
 */
public class _Snapshot_Array_{
    /**
     * TreeMap List to store the historical data of given index.
     */
    private TreeMap<Integer, Integer>[] mapList;

    /**
     * Current snap ID.
     */
    int snap_id = 0;

    public _Snapshot_Array_(int length) {
        mapList = new TreeMap[length];
        // Initialize TreeMap List
        for (int i = 0; i < length; i++) {
            mapList[i] = new TreeMap<Integer, Integer>();
            mapList[i].put(0, 0);
        }
    }

    /**
     * Set API to store the changed index, val and snap_id.
     * TC = O(logS), S = # of calling set().
     */
    public void set(int index, int val) {
        mapList[index].put(snap_id, val);
    }

    /**
     * Snap API.
     * TC = O(1)
     */
    public int snap() {
        return snap_id++;
    }

    /**
     * Get API to fetch the historical array in given snap_id.
     * TC = O(logs), s = # of calling snap().
     */
    public int get(int index, int snap_id) {
        return mapList[index].floorEntry(snap_id).getValue();
    }
}