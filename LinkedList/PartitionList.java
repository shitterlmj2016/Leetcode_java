/**
 * This is a comment!
 *
 * @class: PartitionList
 * @description: 86. Partition List
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 22:59
 **/
public class PartitionList {
    //小头部和大头部
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(666);
        ListNode bigHead = new ListNode(777);
        ListNode small = smallHead;
        ListNode big = bigHead;

        while (head != null) {
            if (head.val < x) {
                small.next = new ListNode(head.val);
                small = small.next;
            } else {
                big.next = new ListNode(head.val);
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
