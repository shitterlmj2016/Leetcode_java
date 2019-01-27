import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: BinaryTreeLevelOrderTraversal
 * @description: 102. Binary Tree Level Order Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 00:35
 **/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        help(res, map, root, 0);
        return res;
    }

    private void help(List<List<Integer>> res, HashMap<Integer, ArrayList<Integer>> map, TreeNode node, int index) {
        if (node == null)
            return;
        ArrayList<Integer> list;
        if (!map.containsKey(index)) {
            list = new ArrayList<>();
            list.add(node.val);
            map.put(index, list);
            res.add(list);
        } else {
            list = map.get(index);
            list.add(node.val);
        }
        help(res, map, node.left, index + 1);
        help(res, map, node.right, index + 1);
    }
}

