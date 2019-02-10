/**
 * This is a comment!
 *
 * @class: RemoveLinkedListElements
 * @description: 203. Remove Linked List Elements
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 00:14
 **/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return dummy.next;

    }
}
