/**
 * This is a comment!
 *
 * @class: FactorialTrailingZeroes
 * @description: Factorial Trailing Zeroes
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 22:00
 **/
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        //0只有2*5才会产生 2比5多，只要有5就会产生0
        if (n == 0)
            return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
