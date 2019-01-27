/**
 * This is a comment!
 *
 * @class: ValidateBinarySearchTree
 * @description: 98. Validate Binary Search Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:51
 **/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        return help(root, null, null);
    }


    private boolean help(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        if (min != null && node.val <= min)
            return false;
        if (max != null && node.val >= max)
            return false;
        return (help(node.left, min, node.val) && help(node.right, node.val, max));
    }
}
