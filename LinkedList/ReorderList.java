import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: ReorderList
 * @description: Reorder List
 * @author: Xincheng Huang - xinchenh
 * @create: 02-05-2019 20:27
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode fast = head, slow = head, prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        slow = reverse(slow);

        merge(head, slow);
    }

    private void merge(ListNode head, ListNode slow) {
        while (head != null) {
            ListNode n1 = head.next;
            ListNode n2 = slow.next;
            head.next = slow;
            if (n1 == null)
                break;
            slow.next = n1;
            head = n1;
            slow = n2;
        }
    }

    private ListNode reverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();
        ListNode curr = newHead;
        while (!stack.empty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
    }
}
