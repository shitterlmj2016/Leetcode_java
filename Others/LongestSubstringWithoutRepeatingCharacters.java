
//sliding window [i,j] -> [i+1, j+1]
//" a b b a b c b b"
//a b b c b
//假想有一个向右移动的窗口
//不断移动，一旦遇到重复的就将重复之前的都清零，然后从重复的元素开始重新计数
//t: o(n) s: o(n)
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null && s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (int i = 0, j=0; i <s.length() ;) {
            if(set.contains(s.charAt(i)))
                set.remove(s.charAt(j++));
            else
                set.add(s.charAt(i++));

            len = Math.max(len,set.size());
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbabcbb"));
    }
}
