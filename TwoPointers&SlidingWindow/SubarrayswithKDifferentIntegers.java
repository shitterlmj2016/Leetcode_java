import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: SubarrayswithKDifferentIntegers
 * @description: Subarrays with K Different Integers
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 12:09
 **/
public class SubarrayswithKDifferentIntegers {


    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || K > A.length)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        int end = 0;
        while (end < A.length) {
            if (map.size() <= K) {
                map.put(A[end], end);
                end++;
            }
            if (map.size() > K) {
                int minStart = A.length;
                for (int i : map.keySet()
                ) {
                    minStart = Math.min(minStart, map.get(i));
                }
                map.remove(A[minStart]);
                start = minStart + 1;
            }

            if (map.size() == K) {
                int minStart = A.length;
                for (int i : map.keySet()
                ) {
                    minStart = Math.min(minStart, map.get(i));
                }
                res += minStart - start + 1;
            }
        }

        return res;
    }
}
