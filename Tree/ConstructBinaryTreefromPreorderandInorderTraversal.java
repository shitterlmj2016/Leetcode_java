/**
 * This is a comment!
 *
 * @class: ConstructBinaryTreefromPreorderandInorderTraversal
 * @description: Construct Binary Tree from Preorder and Inorder Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 20:00
 **/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart < 0 || preStart >= preorder.length || inStart > inEnd)
            return null;

        int inIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart])
                inIndex = i;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
