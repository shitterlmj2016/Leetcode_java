
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    //My solution
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            //重复的值只保存最后一个的
        }
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(0 - nums[i] - nums[j])) {
                    int k = map.get(0 - nums[i] - nums[j]);
                    if (k > j) {//只要大于就可以
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        list.add(temp);
                    }
                }
            }
        }

        return list;
    }


    //Best solution
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            // if (nums[i + 1] == nums[i]) 错了！重复的元素应该考虑第一个，然后把后面的跳过
            if(i>0&&nums[i]==nums[i-1])
                continue; // 去重

            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < nums.length - 1 && nums[lo + 1] == nums[lo])
                        lo++;
                    while (hi > 0 && nums[hi] == nums[hi - 1])
                        hi--;
                    lo++;
                    hi--; //这里同时进行两部操作，因为两个数的和只可能有一个，如果lo不变只变hi，既然此时为0，则下一步和一定不为0
                } else if (nums[lo] + nums[hi] < sum)
                    lo++;
                else hi--;

            }

        }
        return list;

    }


    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,4};
        System.out.println(threeSum2(nums));
    }

}
