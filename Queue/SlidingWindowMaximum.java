import java.util.Deque;
import java.util.LinkedList;

/**
 * This is a comment!
 *
 * @class: SlidingWindowMaximum
 * @description: 239. Sliding Window Maximum
 * @author: Xincheng Huang - xinchenh
 * @create: 03-02-2019 11:21
 **/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty()&&deque.peekFirst() == i - k)
                deque.pollFirst();//最大的过时了
            while (!deque.isEmpty()&&nums[deque.peekLast()] < nums[i])
                deque.pollLast();//有大的加入
            deque.offer(i);
            if (i + 1 - k >= 0)//插入数据
                res[i + 1 - k] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
