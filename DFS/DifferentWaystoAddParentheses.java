import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left
                ) {
                    for (int r : right
                    ) {
                        if (c == '+')
                            res.add(l + r);
                        if (c == '-')
                            res.add(l - r);
                        if (c == '*')
                            res.add(r * l);
                    }
                }
            }
        }

        //只有数字，没有符号
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("12+34".substring(3));
    }
}
