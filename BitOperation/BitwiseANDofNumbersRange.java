/**
 * This is a comment!
 *
 * @class: BitwiseANDofNumbersRange
 * @description: 201. Bitwise AND of Numbers Range
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 21:34
 **/
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        //这个区间所有数之和
        /*
        101010100
               01
               10
        101010111
              00 1
              101

         */
        int offset = 0;
        while (m != n) {
            offset++;
            m >>= 1;
            n >>= 1;
        }
        m <<= offset;
        return m;
    }
}
