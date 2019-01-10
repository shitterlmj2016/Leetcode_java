import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//不能去重，因为可能目标是两个或多个相同的值相加
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//可以去重，一定会来一次
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (sum < target)
                        lo++;
                    else hi--;
                }


            }
//            while (i > 0 && nums[i] == nums[i - 1])
//                i++;

        }
        return list;

    }

    public static void main(String[] args) {
        int[] array = {-100,0,0,0,0,1,3};
        System.out.println(fourSum(array, 0));
    }
}
