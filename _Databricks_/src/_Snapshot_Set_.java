import java.util.*;

public class _Snapshot_Set_ {

    private Map<Integer, Boolean> snapMap, curMap;

    public _Snapshot_Set_() {
        snapMap = new HashMap<>();
        curMap = new HashMap<>();
    }

    public void add(int val) {
        if (snapMap.containsKey(val)) {
            snapMap.put(val, true);
        } else {
            curMap.put(val, true);
        }
    }

    public void remove(int val) {
        if (snapMap.containsKey(val)) {
            snapMap.put(val, false);
        } else {
            curMap.remove(val);
        }
    }

    public boolean contains(int val) {
        if (snapMap.getOrDefault(val, false)) {
            return true;
        }
        if (curMap.containsKey(val)) {
            return true;
        }
        return false;
    }

    public MyIterator iterator() {
        snapMap = curMap;
        curMap = new HashMap<>();
        return new MyIterator(snapMap, curMap);
    }

    public class MyIterator implements Iterator<Integer> {

        private Map<Integer, Boolean> snapMap, curMap;

        private Iterator<Integer> iterator;

        public MyIterator(Map<Integer, Boolean> snapMap, Map<Integer, Boolean> curMap) {
            this.snapMap = new HashMap<>(snapMap);
            this.curMap = new HashMap<>(curMap);
            this.iterator = this.snapMap.keySet().iterator();
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = iterator.hasNext();
            if (hasNext == false) {
                snapMap.clear();
            }
            return hasNext;
        }

        @Override
        public Integer next() {
            int val = iterator.next();
            if (snapMap.get(val)) {
                curMap.put(val, true);
            }
            return val;
        }
    }

    public static void main(String[] args) {
        _Snapshot_Set_ set = new _Snapshot_Set_();
        set.add(2);
        set.add(5);
        set.add(8);
        set.remove(5);
        MyIterator it1 = set.iterator();
        set.add(1);
        set.remove(2);
        set.add(5);
        MyIterator it2 = set.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
