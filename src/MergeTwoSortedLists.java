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


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      return null;

    }
}
