public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {

                curr.next = new ListNode(l1.val);
                l1 = l1.next;

            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;//剩下的部分连起来
        } else {
            curr.next = l2;
        }

        return dummy.next;

    }

    //递归法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l1.val<l2.val)
        {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }

        else
        {

            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}
