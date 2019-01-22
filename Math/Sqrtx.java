/**
 * This is a comment!
 *
 * @class: Sqrtx
 * @description: 69. Sqrt(x)
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 17:40
 **/
public class Sqrtx {

    public static int mySqrt(int x) {
        long lo = 0;
        long hi = x;
        while (lo <= hi) {
            long mid = (hi - lo) / 2 + lo;
            if (mid * mid > x || mid * mid < 0) //overflow
                hi = mid - 1;
            else lo = mid + 1;
        }
        int res = (int)((lo + hi) / 2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2147395599-Integer.MAX_VALUE);
    }
}
