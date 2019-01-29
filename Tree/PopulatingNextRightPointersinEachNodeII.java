/**
 * This is a comment!
 *
 * @class: PopulatingNextRightPointersinEachNodeII
 * @description: 不是完全二叉树
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 19:40
 **/
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode curr = root;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;

        while (curr != null) {//全局
            while (curr != null)//每一层
            {
                if (curr.left != null) {
                    if (prev != null)//head 肯定有了
                    {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;

                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            prev = null;
            head = null;
        }


    }

}
