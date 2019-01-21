import java.nio.channels.Channel;
import java.util.Stack;


//1. ([)}
//2. (
//3. ]
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()
        ) {
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())//排除 3||1 }
                return false;
        }

        return stack.isEmpty(); //排除2
    }
}
