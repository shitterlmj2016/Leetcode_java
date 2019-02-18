/**
 * This is a comment!
 *
 * @class: CountCompleteTreeNodes
 * @description: 222. Count Complete Tree Nodes
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 11:53
 **/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
