/**
 * This is a comment!
 *
 * @class: PathSum
 * @description: 112. Path Sum
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 22:28
 **/
public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        return help(root, sum);
    }

    private boolean help(TreeNode root, int sum) {
        if (root == null)//可能有负数，不能用root.val > tree 来判断
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return help(root.left, sum - root.val) || help(root.right, sum - root.val);
    }
}
