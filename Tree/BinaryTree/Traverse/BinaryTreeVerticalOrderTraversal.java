package BinaryTree.Traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Leetcode_java
 * @description: 314. Binary Tree Vertical Order Traversal
 * @author: Xincheng Huang
 * @create: 2019-03-23 21:42
 **/

public class BinaryTreeVerticalOrderTraversal {
    private int min;
    private int max;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);

        for (int i = min; i <= max; i++) { //注意是小于等于
            res.add(new ArrayList<>());
        }

        Queue<Integer> indexQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>(); //一一对应
        nodeQueue.offer(root);
        //-1
        indexQueue.offer(-min); //这步很关键，翻转了min，即min是0，root是-min，max是-min+max 保证线性表index从0开始

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int index = indexQueue.poll();
            res.get(index).add(node.val);

            if (node.left != null) {
                nodeQueue.offer(node.left);
                indexQueue.offer(index - 1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                indexQueue.offer(index + 1);
            }
        }
        return res;
    }

    private void helper(TreeNode root, int i) {
        if (root == null) return;
        min = Math.min(i, min);
        max = Math.max(i, max);
        helper(root.left, i - 1);
        helper(root.right, i + 1);
    }
}
