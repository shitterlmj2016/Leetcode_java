/**
 * This is a comment!
 *
 * @class: KthSmallestElementinaBST
 * @description: Kth Smallest Element in a BST
 * @author: Xincheng Huang - xinchenh
 * @create: 02-23-2019 10:16
 **/
public class KthSmallestElementinaBST {
    int res = 0;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }

    //中序遍历是递增
    private void helper(TreeNode root) {
        if (root == null || count <= 0) return;

        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }

        helper(root.right);
    }
}
