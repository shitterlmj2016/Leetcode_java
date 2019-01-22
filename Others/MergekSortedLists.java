import java.util.PriorityQueue;

/**
 * This is a comment!
 *
 * @class: MergekSortedLists
 * @description: 23. Merge k Sorted Lists
 * @author: Xincheng Huang - xinchenh
 * @create: 01-21-2019 23:17
 **/
public class MergekSortedLists {


    //PiorityQueue 推荐

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);


        for (ListNode n : lists
        ) {
            if (n != null)
                pq.add(n);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next; //把尾巴后面一串加进去了
            if (curr.next != null) //如果后面还有的话
            {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }


    //分治
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi)
            return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode n1 = sort(lists, lo, mid);
        ListNode n2 = sort(lists, mid + 1, hi);
        return merge(n1, n2);
    }

    //merge 是重点！
    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        if (n1.val < n2.val) {
            n1.next = merge(n1.next, n2);
            return n1;
        } else {

            n2.next = merge(n2.next, n1);
            return n2;
        }
    }


}
