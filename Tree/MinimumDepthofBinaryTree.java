/**
 * This is a comment!
 *
 * @class: MinimumDepthofBinaryTree
 * @description: 111. Minimum Depth of Binary Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 21:41
 **/
public class MinimumDepthofBinaryTree {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        help(root, 1);
        return min;
    }

    private void help(TreeNode root, int i) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            min = Math.min(min, i);
        help(root.left, i + 1);
        help(root.right, i + 1);
    }

    public static void main(String[] args) {
        TreeNode n1,n2,n3;
        n1 = new TreeNode(9);
        n2 = new TreeNode(20);
        n3 = new TreeNode(3);
        n3.left =n1;
        n3.right = n2;
        MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
        System.out.println(m.minDepth(n3));

    }
}
