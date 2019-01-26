/**
 * This is a comment!
 *
 * @class: MinimumWindowSubstring
 * @description: 76. Minimum Window Substring
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 15:16
 **/

//超级无敌特别重要，背也要背下来！

    /*
     s:    A D O B E C O D E B A N C

    cnt:   A   B   C   N   O      total   min   j   start
           1   1   1   0   0      3       MAX   0    0

           0   1   1   0   0      2
           0   1   1   0   -1

     s:    A D O B E C O D E B A N C
           ^         ^
           0   0   0              0       6


     s:    A D O B E C O D E B A N C
                 ^                 ^
           0   0   0              0     total: 1
     */


public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t == null || t.length() == 0)
            return "";

        int[] cnt = new int[128]; //一共128个ascii
        for (char c : t.toCharArray()
        ) {
            cnt[c]++;
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        int total = t.length();
        //ADOBECODEBANC
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--; //注意这里要--
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    start = j;
                }

                if (++cnt[s.charAt(j++)] > 0)
                    total++;
            }
        }


        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC","ABC");
    }
}
