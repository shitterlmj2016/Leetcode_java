/**
 * This is a comment!
 *
 * @class: ShortestPalindrome
 * @description: 214. Shortest Palindrome
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 10:02
 **/
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int i = 0;
        int j = s.length() - 1;
        int end = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                end--;
                i = 0;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().append(s).toString();
    }

    public static void main(String[] args) {

    }
}
