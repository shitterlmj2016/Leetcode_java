/**
 * This is a comment!
 *
 * @class: RotateList
 * @description: 61. Rotate List
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 22:22
 **/
public class RotateList {

    /*
    1->2->3->4->5->NULL
    ^           ^

     */
    public ListNode rotateRight(ListNode head, int k) {
//统计长度，先连城环，再找地方断开
        if (head == null || head.next == null || k == 0)
            return head;
        int count = 1;

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        curr.next = head; // loop
        curr = head;
        // 2
        for (int i = 0; i < count - k % count -1; i++) {
            curr = curr.next;
        }
        ListNode res = curr.next;
        curr.next = null;
        return res;

    }
}
