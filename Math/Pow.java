/**
 * This is a comment!
 *
 * @class: Pow
 * @description: 50. Pow(x, n)
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 23:37
 **/
public class Pow {
    //递归
/*
相当于给结果一直开方，一但遇到奇数次方，则分一个x出来 x^3 = x^2 * x 然后继续开方
 */

    /*
    2^5 = 2^2 * 2^2 *2^1 = 2^1 * 2^1 * 2^1 * 2^1 *
     */


    public double myPow(double x, int n) {
        if (n < 0)
            return 1.0 / pow(x, n);
        return pow(x, n);
    }

    private double pow(double x, int n) {

        if (n == 1) //这步是优化的，可以不用
            return x;
        if (n == 0)
            return 1;

        double y = pow(x, n / 2);
        if (n % 2 == 0) // y是上一步的开方
            return y * y;
        return y * y * x;
    }
}
