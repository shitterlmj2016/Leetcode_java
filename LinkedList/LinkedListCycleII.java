/**
 * This is a comment!
 *
 * @class: LinkedListCycleII
 * @description: 142. Linked List Cycle II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-04-2019 00:02
 **/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        fast = head;

        while (fast != null && slow != null && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
