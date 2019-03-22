/**
 * @program: Leetcode_java
 * @description: 307. Range Sum Query - Mutable
 * @author: Xincheng Huang
 * @create: 2019-03-21 13:41
 **/

public class RangeSumQueryMutable {
}

class NumArray1{
    int[] nums;
    int[] tree;

    //最容易，用update初始化，
    public NumArray1(int[] nums) {
        this.nums = new int[nums.length]; //不能直接初始化， 不然diff就是0
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }

    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        for (; i < tree.length; i += i & -i) {
            tree[i] += diff;
        }

    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int i) {
        int sum = 0;
        for (; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}

class NumArray2 {
    int[] nums;
    int[] tree;

    public NumArray2(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 1; i < tree.length; i++) {
            //8 -> 1
            for (int j = i; j > i - (i & -i); j--) {
                tree[i] += nums[j - 1];
            }
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        for (; i < tree.length; i += i & -i) {
            tree[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }

}