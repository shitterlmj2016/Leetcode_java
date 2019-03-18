import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        helper(s, res, 0, 0, '(', ')');
        return res;
    }

    /*
    ( ) ) )
      j
        i
    ( ) )
      j i

     */

    private static void helper(String s, List<String> res, int last_i, int last_j, char c1, char c2) {
        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == c1) count++;
            if (s.charAt(i) == c2) count--;
            if (count >= 0) continue;

            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == c2 && (j == last_j || s.charAt(j - 1) != c2)) {
                    helper(s.substring(0, j) + s.substring(j + 1), res, i, j, c1, c2);
                }
            }
            return;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if (c1 == '(') {
            helper(reverse, res, 0, 0, c2, c1);
        } else {
            res.add(reverse);
        }
    }
}
