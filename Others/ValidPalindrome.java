/**
 * This is a comment!
 *
 * @class: ValidPalindrome
 * @description: 125. Valid Palindrome
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 23:05
 **/
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()
        ) {
            if (isChar(c))
                temp.append(c);
        }
        System.out.println(temp.toString());
        int lo = 0;
        int hi = temp.length() - 1;
        while (lo <= hi) {
            if (temp.charAt(lo) != temp.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }

    private static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' || c <= '9');
    }

    public static void main(String[] args) {
        System.out.println("12d-kc1m1e-onvaspd1w03<{:Q!@)!".replaceAll("[^a-zA-Z0-9]","").toLowerCase());
    }
}
