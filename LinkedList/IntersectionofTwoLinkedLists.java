import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: IntersectionofTwoLinkedLists
 * @description: Intersection of Two Linked Lists
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 22:10
 **/
public class IntersectionofTwoLinkedLists {
    //大家都会烂九流
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (set.contains(curr))
                return curr;
            curr = curr.next;
        }

        return null;
    }

    //巧妙双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while (curr1 != curr2) {
            if (curr1 == null)
                curr1 = headA;
            else
                curr1 = curr1.next;
            if (curr2 == null)
                curr2 = headB;
            else curr2 = curr2.next;

        }
        return curr1;

    }
}
