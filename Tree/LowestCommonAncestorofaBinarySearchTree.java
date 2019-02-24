/**
 * This is a comment!
 *
 * @class: LowestCommonAncestorofaBinarySearchTree
 * @description: Lowest Common Ancestor of a Binary Search Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 02-22-2019 12:50
 **/
public class LowestCommonAncestorofaBinarySearchTree {

    //看左右
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
