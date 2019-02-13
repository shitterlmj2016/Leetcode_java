import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: BinarySearchTreeIterator
 * @description: Binary Search Tree Iterator
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 23:51
 **/
public class BSTIterator {


    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode temp = stack.pop();
        TreeNode curr = temp.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return temp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
