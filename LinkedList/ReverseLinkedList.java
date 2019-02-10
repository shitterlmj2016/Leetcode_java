import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: ReverseLinkedList
 * @description: 206. Reverse Linked List
 * @author: Xincheng Huang - xinchenh
 * @create: 02-09-2019 17:34
 **/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;
            head.next = next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }

        return dummy.next;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static ListNode reverseList21(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        help(head, head.next, dummy);
        return dummy.next;
    }

    private static ListNode help(ListNode head, ListNode next, ListNode dummy) {
        if (next == null) {
            dummy.next = head;
            return head;
        }
        ListNode prev = help(next, next.next, dummy);
        prev.next = head;
        return head;
    }


    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(-11);
        ListNode curr = dummy;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;

        System.out.println(reverseList21(n1).val);
    }
}
