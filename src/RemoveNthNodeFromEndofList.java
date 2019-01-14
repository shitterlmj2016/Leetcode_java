import java.util.List;

//19
//双指针
// dummy -> A->B->C->D->E n->
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null; //dummy node 是为了解决只有一个节点的情况
        //如果把head move 掉了那就return dummy.next

        //  ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = head;
        //  dummy.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //移出界了 即去掉第一个
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}


