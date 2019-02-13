/**
 * This is a comment!
 *
 * @class: RotateArray
 * @description: Rotate Array
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 13:51
 **/
public class RotateArray {
    /*
      0 1 2 3 4 5 6
      1 2 3 4 5 6 7
      7 6 5 4 3 2 1
      5 6 7 1 2 3 4
     [5,6,7,4,1,2,3]
     [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0)
            return;
        k = k % nums.length;
       reverse(nums,0,nums.length-1);
       reverse(nums,0,k-1);
       reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
