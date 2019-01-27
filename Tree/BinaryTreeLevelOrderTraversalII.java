import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is a comment!
 *
 * @class: BinaryTreeLevelOrderTraversalII
 * @description: 107. Binary Tree Level Order Traversal II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 11:24
 **/
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue.size());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                queue.offer(node.right);
            }
            res.add(0, list);
        }
        return res;

    }
}
