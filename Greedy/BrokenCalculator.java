/**
 * This is a comment!
 *
 * @class: BrokenCalculator
 * @description: 991. Broken Calculator
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 21:37
 **/
public class BrokenCalculator {
    //贪心 从Y到X，自己再看一遍解答下面评论
    //乘法会放大+，但是除法只会缩小—
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            res++;
            if (Y % 2 == 0)
                Y = Y / 2;
            else
                Y++;
        }
        return res + X - Y;
    }
}
