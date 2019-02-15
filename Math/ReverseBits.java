/**
 * This is a comment!
 *
 * @class: ReverseBits
 * @description: Reverse Bits
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 20:30
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        if (n == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {//一共32位
            res <<= 1;
            if ((n & 1) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }

    public static int hammingWeight(int n) {
        if (n == 0)
            return 0;
        return n & 1 + hammingWeight(n >> 1);
    }

    public static void main(String[] args) {
        System.out.println(101>>1);
    }
}
