/**
 * This is a comment!
 *
 * @class: ConvertSortedArraytoBinarySearchTree
 * @description: 108. Convert Sorted Array to Binary Search Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 21:20
 **/
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int mid = (hi - lo) / 2 + lo;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, lo, mid - 1);
        root.right = help(nums, mid + 1, hi);
        return root;
    }


    //我的错误的方法，可以实现但不平衡
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int mid = nums[nums.length / 2];
        TreeNode root = new TreeNode(mid);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != mid)
                root = helper2(root, nums[i]);
        }
        return root;
    }

    private TreeNode helper2(TreeNode root, int num) {
        if (root == null)
            return new TreeNode(num);
        if (root.val < num)
            root.right = helper2(root.right, num);
        else
            root.left = helper2(root.left, num);
        return root;
    }
}
