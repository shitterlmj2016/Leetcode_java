import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This is a comment!
 *
 * @class: TheSkylineProblemm
 * @description: 218. The Skyline Problem
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 22:36
 **/
public class TheSkylineProblemm {
    public List<int[]> getSkyline(int[][] buildings) {

        ArrayList<int[]> height = new ArrayList<>();
        for (int[] num : buildings
        ) {
            height.add(new int[]{num[0], -num[2]});
            height.add(new int[]{num[1], num[2]});
        }

        Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(0);
        ArrayList<int[]> res = new ArrayList<>();
        int prev = 0;
        for (int[] num : height
        ) {
            if (num[1] < 0) {
                pq.offer(-num[1]);
            } else {
                pq.remove(num[1]);
            }
            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[]{num[0], curr});
                prev = curr;
            }
        }
        return res;
    }
}
