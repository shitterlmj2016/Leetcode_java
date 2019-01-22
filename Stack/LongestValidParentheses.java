import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: LongestValidParentheses
 * @description: 32. Longest Valid Parentheses
 * @author: Xincheng Huang - xinchenh
 * @create: 01-21-2019 00:21
 **/
public class LongestValidParentheses {
    /*
))()
((())))

     */
    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty())
                    start = i;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        res = Math.max(res, i - start);
                    else
                        res = Math.max(res, i - stack.peek());
                }
            }


        }
        return res;
    }

}
