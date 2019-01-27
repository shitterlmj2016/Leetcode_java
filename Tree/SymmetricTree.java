/**
 * This is a comment!
 *
 * @class: SymmetricTree
 * @description: 101. Symmetric Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 00:27
 **/
//与100相同
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return help(root, root);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return help(left.left, right.right) && help(right.left, left.right);
    }
}
