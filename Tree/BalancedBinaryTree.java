/**
 * This is a comment!
 *
 * @class: BalancedBinaryTree
 * @description: 110. Balanced Binary Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 19:51
 **/
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return (help(root) != -1);

    }

    private int help(TreeNode node) {
        if (node == null)
            return 0;
        int l = help(node.left);
        int r = help(node.right);
        if (Math.abs(l - r) > 1 || l == -1 || r == -1)
            return -1;
        return Math.max(l, r) + 1;
    }
}
