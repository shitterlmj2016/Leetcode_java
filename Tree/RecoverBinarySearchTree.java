/**
 * This is a comment!
 *
 * @class: RecoverBinarySearchTree
 * @description: 99. Recover Binary Search Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 23:34
 **/
public class RecoverBinarySearchTree {
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        help(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void help(TreeNode node) {
        if (node == null) return;
        help(node.left);
        if (pre != null && pre.val > node.val) {
            if (first == null)
                first = pre;
            second = node;
        }
        pre = node;
        help(node.right);
    }
}
