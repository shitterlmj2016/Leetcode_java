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
        int lo = 0;
        int hi = x;
        while (lo <= hi) {
            long mid = (hi - lo) / 2 + lo;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x) //overflow
                hi = (int) mid - 1;
            else lo = (int) mid + 1;
        }
        if (hi * hi < x) return hi;
        else return lo;
    }

    public static void main(String[] args) {

    }
}
