//82 与 83 的不同是含有重复的要全部删除，不是留一个


public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null)  有dummy，不需要
//            return head;

        // 1

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while (curr.next != null && curr.next.val == val)
                    curr.next = curr.next.next;
            }

          else   curr = curr.next; //注意else
        }


        return dummy.next;


    }
}
