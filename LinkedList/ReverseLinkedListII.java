/**
 * This is a comment!
 * 92. Reverse Linked List II
 *
 * @class: ReverseLinkedListII
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 23:13
 **/
public class ReverseLinkedListII {
    //区别是反转m和n之间的链表

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

                /*
                1->2->3->4->5
                 */
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        /*
        1->2->3->4->5
        P  c  T



         */

        for (int i = 0; i < m - n; i++) {

            ListNode temp = curr.next;
            curr.next = temp.next; //(1)
            temp.next = pre.next; // 1(3)->2->4->5
            pre.next = temp;//1 3 2 4 5


        }
        return dummy.next;
    }
}
