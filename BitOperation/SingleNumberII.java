import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: SingleNumberII
 * @description: Single Number II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-05-2019 22:39
 **/

/*

        1     0
  0 0   1 0  0  0
  1 0   0 1  1  0
  0 1   0 0  0  1

  00


 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static int singleNumber2(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums
            ) {
                if (map.containsKey(i))
                    map.put(i, map.get(i) + 1);
                else
                    map.put(i, 1);
            }

            for (int i : nums
            ) {
                if (map.get(i) == 1)
                    return i;
            }
            return -1;
    }


    public static void main(String[] args) {
        int a[] = {1, 1, 1, 3, 3, 3, 2};
        singleNumber2(a);
    }
}
