
//24
//纯链表题

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
       // if (head == null || head.next == null)
          //  return head;
        //其实不需要

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy.next;
        while (p2!= null && p2.next!= null) { //注意边界条件
            ListNode next = p2.next.next;
            p2.next.next = p2;//这边用iPad画一下图
            p1.next = p2.next;
            p2.next = next;
            p1 = p2;
            p2 = p2.next;

        }
        return dummy.next;
    }
}
