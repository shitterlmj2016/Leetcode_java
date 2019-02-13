import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: TwoSumII
 * @description: Two Sum II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 21:18
 **/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target)
                return new int[]{lo + 1, hi + 1};
            else if (sum > target)
                hi--;
            else lo++;
        }
        return null;
    }
}

class TwoSum {
    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, Integer> map = new HashMap<>();

    public TwoSum() {
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (map.containsKey(number))
            map.put(number, 2);
        else map.put(number, 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i : map.keySet()
        ) {
            if (i * 2 == value) {
                if (map.get(i) == 2)
                    return true;
            } else {
                if (map.containsKey(value - i))
                    return true;
            }
        }
        return false;
    }
}
