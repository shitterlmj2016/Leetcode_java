/**
 * This is a comment!
 *
 * @class: ReverseVowelsofaString
 * @description: Reverse Vowels of a String
 * @author: Xincheng Huang - xinchenh
 * @create: 02-22-2019 00:43
 **/
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2)
            return s;
        StringBuilder sb = new StringBuilder(s);
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (!isVowel(sb.charAt(lo)))
                lo++;
            else if (!isVowel(sb.charAt(hi)))
                hi--;
            else {
                exch(sb, lo, hi);
                lo++;
                hi--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void exch(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
