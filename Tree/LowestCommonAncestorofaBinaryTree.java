/**
 * This is a comment!
 *
 * @class: LowestCommonAncestorofaBinaryTree
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 02-24-2019 23:57
 **/
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
