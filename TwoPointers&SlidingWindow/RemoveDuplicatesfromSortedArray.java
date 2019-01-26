//26
//双指针问题
// t:o(n) s: O(1)


public class RemoveDuplicatesfromSortedArray {


    public int removeDuplicates(int[] nums) {

        if(nums==null||nums.length==0)
            return 0;

        //第一个肯定不重复，所以从第二个开始数；
        int count =1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[i-1])
                nums[count++] = nums[i];
        }

        return count;
    }



}
