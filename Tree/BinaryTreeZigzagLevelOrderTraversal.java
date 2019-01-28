import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is a comment!
 *
 * @class: BinaryTreeZigzagLevelOrderTraversal
 * @description: 103. Binary Tree Zigzag Level Order Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 11:55
 **/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue.size());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0)
                    list.add(node.val);
                else
                    list.add(0, node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add( list);
            level++;
        }
        return res;
    }
    }

