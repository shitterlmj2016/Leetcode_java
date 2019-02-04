import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: CopyListwithRandomPointer
 * @description: 138. Copy List with Random Pointer
 * @author: Xincheng Huang - xinchenh
 * @create: 02-02-2019 22:40
 **/
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }


    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode next = curr.next;
            RandomListNode child = new RandomListNode(curr.label);
            curr.next = child;
            child.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode rcurr = dummy;
        while (curr != null) {
            rcurr.next = curr.next;
            rcurr = rcurr.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
