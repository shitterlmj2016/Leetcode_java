/**
 * @class: MutiplyString
 * @description: 43. Multiply Strings
 * @author: Xincheng Huang - xinchenh
 * @create: 01-16-2019 09:42
 **/


/**
 * 1 2 3
 * 4 5
 * -------------
 * 1 5
 * 1 0
 * 0 5
 * 1 2
 * 0 8
 * 0 4
 * <p>
 * MaxLength = i+j
 */


public class MutiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "0";
        int res[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //考虑进位
                int sum = res[i + j + 1] + temp;  //?前一位会不会进位？ 不可能 9*9 = 81   8 + 1 = 9 不可能进位
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0 || sb.length() != 0)
                sb.append(res[i]);

        }

        //这一步一定要，判断是否为0！不然返回是空的！
        if (sb.length() == 0)
            return "0";


        return sb.toString();
    }
}
