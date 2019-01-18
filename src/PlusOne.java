/**
 * This is a comment!
 *
 * @class: PlusOne
 * @description: 66. Plus One
 * @author: Xincheng Huang - xinchenh
 * @create: 01-18-2019 00:04
 **/

/*
这题很重要，可以做的很简洁很干脆，需要仔细复习

case 1 : 123 -> 124
case 2 : 199 -> 200
case 3 : 999 -> 1000

从最后一位往前判断

 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else digits[i] = 0; //很巧妙，又会回到上一步，循环往复
        }

        //走到这里的话就说明 是 999这种情况，直接返回 1000就行

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
