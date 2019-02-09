/**
 * This is a comment!
 *
 * @class: InsertionSortList
 * @description: Insertion Sort List
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 20:05
 **/
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;//这句不能少！
        ListNode fast = head;
        while (true) {
            while (fast.next != null && fast.val <= fast.next.val) {
                fast = fast.next;
            }

            if (fast.next == null)
                break;

            ListNode slow = dummy;
            while (slow.next != null && slow.next.val < fast.next.val) {
                slow = slow.next;
            }

            if (slow.next != null && fast.next != null) {
                ListNode slowNext = slow.next;
                ListNode fastNext = fast.next;
                fast.next = fast.next.next;
                fastNext.next = slowNext;
                slow.next = fastNext;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        insertionSortList(n1);
    }
}
