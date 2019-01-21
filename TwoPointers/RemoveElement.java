//27
//双指针问题: 类似26
// t:o(n) s: O(1)
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)
            return 0;

        //第一个肯定不重复，所以从第二个开始数；
        int count =0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=val)
                nums[count++] = nums[i];
        }

        return count;
    }

}
