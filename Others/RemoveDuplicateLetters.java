import java.util.HashMap;

/**
 * @program: Leetcode_java
 * @description: 316. Remove Duplicate Letters
 * @author: Xincheng Huang
 * @create: 2019-03-27 17:33
 **/

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int lo = 0;
        int hi = findLowest(map);

        /*
        b c a b c
         */
        char[] res = new char[map.size()];
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int j = lo; j <= hi; j++) {
                char c = s.charAt(j);
                if (map.containsKey(c) && c < minChar) {
                    minChar = c;
                    lo = j + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if (minChar == s.charAt(hi)) {
                hi = findLowest(map);
            }
        }
        return new String(res);
    }


    private int findLowest(HashMap<Character, Integer> map) {
        int min = Integer.MAX_VALUE;//注意不能是mapsize， 应该是原来的字符串长度，
        for (int i : map.values()
        ) {
            min = Math.min(i, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int i = 1;
        while (i > 0) {
            System.out.println(i);
            i = i * 4;
        }
    }
}
