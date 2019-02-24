/**
 * This is a comment!
 *
 * @class: PalindromeLinkedList
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 02-23-2019 11:01
 **/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = reverseList(findMiddle(head));
        while (middle != null) {
            if (head.val != middle.val)
                return false;
            head = head.next;
            middle = middle.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
