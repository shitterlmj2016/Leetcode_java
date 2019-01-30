import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: UniqueBinarySearchTreesII
 * @description: Unique Binary Search Trees II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 20:42
 **/
public class UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0)
            return res;
        return helper(1, n);
    }

    private static ArrayList<TreeNode> helper(int lo, int hi) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            ArrayList<TreeNode> left_child = helper(lo, i - 1);
            ArrayList<TreeNode> right_child = helper(i + 1, hi);

            for (TreeNode l : left_child
            ) {
                for (TreeNode r : right_child
                ) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
