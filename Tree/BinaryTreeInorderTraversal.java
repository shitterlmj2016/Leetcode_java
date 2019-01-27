/**
 * This is a comment!
 *
 * @class: BinaryTreeInorderTraversal
 * @description: 94. Binary Tree Inorder Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:19
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        help(node.left, res);
        res.add(node.val);
        help(node.right, res);
    }


}
