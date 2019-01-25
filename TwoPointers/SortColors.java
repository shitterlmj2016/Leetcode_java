/**
 * This is a comment!
 *
 * @class: SortColors
 * @description: 75. Sort Colors
 * @author: Xincheng Huang - xinchenh
 * @create: 01-24-2019 23:40
 **/
public class SortColors {
    // 2 1 2 0 2
    // 2 1 2 0 2
    // 2 1
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int lo = 0;
        int hi = nums.length - 1;
        int index = lo;

        while (index <= hi) { // 注意这里是hi，不然会换回来变成 00 22 11
            if (nums[index] == 0)
                swap(nums, lo++, index);
            else if (nums[index] == 2)
                swap(nums, hi--, index);
            else index++;
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{1, 2, 0});
    }

}
