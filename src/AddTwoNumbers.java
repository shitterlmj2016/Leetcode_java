public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode a = l1;
        ListNode b = l2;
        int sum = 0;
        while (a != null || b != null) {
            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }
            curr.next = new ListNode(sum % 10); // 核心
            sum = sum / 10;
            curr = curr.next;

        }

        if(sum == 1)
            curr.next = new ListNode(1);//进位

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }