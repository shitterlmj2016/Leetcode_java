/**
 * This is a comment!
 *
 * @class: PopulatingNextRightPointersinEachNode
 * @description: 116. Populating Next Right Pointers in Each Node
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 19:31
 **/
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null && root.next != null) //父母已经帮忙搞好了
        {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

}
