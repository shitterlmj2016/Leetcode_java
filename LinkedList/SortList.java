/**
 * This is a comment!
 *
 * @class: SortList
 * @description: 148. Sort List
 * @author: Xincheng Huang - xinchenh
 * @create: 02-06-2019 16:44
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head, slow = fast, prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode slowHead = sortList(head);
        ListNode fastHead = sortList(slow);
        return merge(slowHead, fastHead);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;
        return dummy.next;
    }

}
