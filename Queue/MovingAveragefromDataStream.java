import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @program: Leetcode_java
 * @description: 346. Moving Average from Data Stream
 * @author: Xincheng Huang
 * @create: 2019-04-01 12:42
 **/

public class MovingAveragefromDataStream {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.higher(0));
    }
}

class MovingAverage {
    int size;
    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return (double) sum / queue.size();
    }

}
