/**
 * @program: Leetcode_java
 * @description: 306. Additive Number
 * @author: Xincheng Huang
 * @create: 2019-03-21 00:03
 **/

public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2)
            return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
                if (isValid(i, j, num))
                    return true;
            }
        }
        return false;
    }

    /*
    1 9 9 1 0 0 1 9 9
     */
    private static boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum = "";
        Long a = Long.valueOf(num.substring(0, i));
        Long b = Long.valueOf(num.substring(i, i + j));
        for (int start = i + j; start < num.length(); start += sum.length()) {
            b = a + b;
            a = b - a;
            sum = String.valueOf(b);
            if (!num.startsWith(sum, start)) return false;
            System.out.println(start);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));
    }
}
