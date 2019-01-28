import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: ConstructBinaryTreefromInorderandPostorderTraversal
 * @description: 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 21:10
 **/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, 0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);

    }

    private TreeNode helper(HashMap<Integer, Integer> map, int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int len = index - inStart;
        root.left = helper(map, inStart, index - 1, postStart, postStart + len - 1, inorder, postorder);
        root.right = helper(map, index + 1, inEnd, postStart + len, postEnd - 1, inorder, postorder);
        return root;


    }
}
