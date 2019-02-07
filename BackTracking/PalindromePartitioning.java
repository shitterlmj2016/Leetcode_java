import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: PalindromePartitioning
 * @description: Palindrome Partitioning
 * @author: Xincheng Huang - xinchenh
 * @create: 02-06-2019 17:55
 **/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (s == null)
            return res;
        help(res, new ArrayList<String>(), s, 0);
        return res;
    }

    private void help(ArrayList<List<String>> res, ArrayList<String> list, String s, int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (ValidPalindrome.isPalindrome(sub)) {
                list.add(sub);
                help(res, list, s, j);
                list.remove(list.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int lo = 0;
        int hi = s.length() - 1;
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }

}

