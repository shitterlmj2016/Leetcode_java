import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: BinaryTreePreorderTraversal
 * @description: 144. Binary Tree Preorder Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:29
 **/
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        res.add(node.val);
        help(node.left, res);
        help(node.right, res);
    }
}
