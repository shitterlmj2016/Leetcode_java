import java.util.Stack;

/**
 * This is a comment!
 *
 * @class: MinStack
 * @description: MinStack
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 18:09
 **/
public class MinStack {
    /**
     * initialize your data structure here.
     */

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0)
            minStack.push(x);
        else
            minStack.push(Math.min(minStack.peek(), x));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
