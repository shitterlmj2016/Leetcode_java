import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: BasicCalculator
 * @description: 224. Basic Calculator
 * @author: Xincheng Huang - xinchenh
 * @create: 02-28-2019 22:46
 **/
public class BasicCalculator {
    /*
    3-(6+8)
    3-(6-8)

    res: -6 -8 +
    stack: 0
    sign: -1
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * num;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign); //注意先后顺序
                sign = 1;
                res = 0;
            } else if (s.charAt(i) == ')') { // 还可能是空格
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+1"));
    }
}
