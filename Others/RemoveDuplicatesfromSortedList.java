//83
//是链表，不需要双指针，不像数组，有区别(双指针问题)
// t:o(n) s: O(1)


//dummy -> 0 -> 1 -> 1 -> 2 -> null
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null)
            return head;

        //不需要dummy因为head肯定是留着的
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null)
        {
            if(fast.val!=fast.next.val)
            {
                slow.next = fast.next;
                slow = slow.next;
            }

            fast = fast.next;

        }

        if(slow.next!=null&&slow.next.val == slow.val) //遇到结尾两个相同的情况会不把相同的去掉
            //需要这一步
        {
            slow.next = null;
        }

        return head;

    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head;
        while(curr.next!=null)
        {
            if(curr.next.val == curr.val)
                curr.next = curr.next.next;
            else  curr = curr.next;

        }
        return head;
    }
}
