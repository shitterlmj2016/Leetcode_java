import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: EvaluateReversePolishNotation
 * @description: 150. Evaluate Reverse Polish Notation
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 19:50
 **/
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens
        ) {

            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int minus = stack.pop();
                stack.push(stack.pop() - minus);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int div = stack.pop();
                stack.push(stack.pop() / div);
            } else
                stack.push(Integer.valueOf(s));
        }

        return stack.peek();
    }
}
