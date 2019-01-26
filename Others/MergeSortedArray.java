/**
 * This is a comment!
 *
 * @class: MergeSortedArray
 * @description: 88. Merge Sorted Array
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 22:49
 **/
public class MergeSortedArray {
    /*
    方法，从后往前减
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        //nums2可能没空，如果空了那就已经结束了
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

}
