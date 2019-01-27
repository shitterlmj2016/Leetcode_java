/**
 * This is a comment!
 *
 * @class: MaximumDepthofBinaryTree
 * @description: 104. Maximum Depth of Binary Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 09:51
 **/
public class MaximumDepthofBinaryTree {
    int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return depth;
        help(root, 1);
        return depth;
    }

    private void help(TreeNode root, int i) {
        if (root == null)
            return;
        depth = Math.max(i, depth);
        help(root.left, i + 1);
        help(root.right, i + 1);
    }

}
