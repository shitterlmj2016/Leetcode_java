/**
 * This is a comment!
 *
 * @class: ConvertSortedListtoBinarySearchTree
 * @description: 109. Convert Sorted List to Binary Search Tree
 * @author: Xincheng Huang - xinchenh
 * @create: 01-27-2019 22:02
 **/
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return help(head, null);
    }

    private TreeNode help(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = help(slow.next, tail);
        root.left = help(head, slow);
        return root;
    }
}
