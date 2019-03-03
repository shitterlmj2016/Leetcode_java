import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: BasicCalculatorII
 * @description: Basic Calculator II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-28-2019 23:25
 **/
public class BasicCalculatorII {

    /*
    3+2*22
    sign
    stack 3 2



     */


    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num += c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            //不能用else， 到结尾之后就算是数字还得加
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+')
                    stack.push(num);
                if (sign == '-')
                    stack.push(-num);
                if (sign == '*')
                    stack.push(stack.pop() * num);
                if (sign == '/')
                    stack.push(stack.pop() / num);
                num = 0;//记得要清零
                sign = c;
            }
        }
        num = 0;
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        return num;
    }

    public static void main(String[] args) {
        calculate("3+2*2");
    }
}
