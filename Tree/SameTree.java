/**
 * This is a comment!
 *
 * @class: SameTree
 * @description: 100. Same Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 23:26
 **/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}
