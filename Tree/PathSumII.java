import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: PathSumII
 * @description: Path Sum II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 12:59
 **/
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        help(root, res, new ArrayList<Integer>(), sum);
        return res;
    }

    private static void help(TreeNode root, List<List<Integer>> res, ArrayList<Integer> list, int sum) {
        if (root == null)
            return;
        if (sum == root.val && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }

        list.add(root.val);
        help(root.left, res, list, sum - root.val);
        list.remove(list.size() - 1);

        list.add(root.val);
        help(root.right, res, list, sum - root.val);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        System.out.println(pathSum(n1, 5));
    }
}
