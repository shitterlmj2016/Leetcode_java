import java.util.Arrays;

public class ThreeSumCloset {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum ==target)
                    return target;
                else if (sum < target)//保证下一次一定比这一次接近target
                    lo++;
                else
                    hi--;
                //最逼近的一个数值
                if (Math.abs(sum - target) < Math.abs(temp - target))
                    temp = sum;
            }

        }

        return temp;
    }


    public static int oldThreeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0)
                    return target;
                if (Math.abs(sum - target) < Math.abs(temp - target)) {
                    temp = sum;
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;
                    lo++;//这里错了lo++和hi--选一个进行草错
                    hi--;
                } else if (sum < target)
                    lo++;
                else
                    hi--;
            }
        }

        return temp;
    }


    public static int oldThreeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum ==target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(temp - target)) {
                    temp = sum;
                }


                while (lo < hi && nums[lo] == nums[lo + 1]) // 需要考虑重复的，不能这么写，如 -20，-19，-19，-18 直接跳过 -20 - 19 -19 的组合

                while (lo < hi && nums[hi] == nums[hi - 1]) {
                    hi--;
                }
                if (sum < target)
                    lo++;
                else
                    hi--;
            }
        }

        return temp;
    }



    public static void main(String[] args) {
        int[] a = {-20,-19,-19,-18};




        System.out.println(oldThreeSumClosest2(a, -59));
    }
}
