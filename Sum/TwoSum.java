//不需要考虑两个相同的数字，hashset中会保存最后一次的，因为只存在一次，可以直接返回
import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        int[] re = new int[2];
        boolean same = false;
        int index = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(target == 2*nums[i])
            {
                same = true;
                re[index++] = i;
            }
            hash.put(nums[i], i);
        }

        if(same&&index == 2)
            return re;


        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (hash.containsKey(a)&&hash.get(target - nums[i])!=i)
            {
                System.out.println();
                re[0] = i;
                re[1] = hash.get(target - nums[i]);
                System.out.println(1);
                break;
            }
        }
        return re;
    }


//
//    public static int []twoSum2(int[] nums, int target)
//    {
//
//    }
    public static void main(String[] args) {
        int[] a = {50,75,25};
        twoSum(a,100);
    }
}
