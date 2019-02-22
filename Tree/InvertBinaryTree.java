/**
 * This is a comment!
 *
 * @class: InvertBinaryTree
 * @description: 226. Invert Binary Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 02-18-2019 11:07
 **/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        return helper(root);
    }

    private TreeNode helper(TreeNode node) {
        TreeNode clone = new TreeNode(node.val);
        if (node.left != null)
            clone.right = helper(node.left);
        if (node.right != null)
            clone.left = helper(node.right);
        return clone;
    }
}
