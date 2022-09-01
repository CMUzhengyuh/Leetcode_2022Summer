import java.util.*;
import java.util.function.Function;
public class _Lazy_Array_ {

    /**
     * Function List.
     */
    private List<Function<Integer, Integer>> list = new ArrayList<>();

    /**
     * Original array.
     */
    private int[] nums;

    public _Lazy_Array_(int[] nums) {
        this.nums = nums;
    }

    /**
     * Store the function description.
     */
    public _Lazy_Array_ map(Function<Integer, Integer> func) {
        list.add(func);
        return this;
    }

    public int indexOf(int num) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            // Apply the function one by one.
            for (Function<Integer, Integer> func : list) {
                val = func.apply(val);
            }
            if (val == num) {
                return i;
            }
        }
        return -1;
    }

}
