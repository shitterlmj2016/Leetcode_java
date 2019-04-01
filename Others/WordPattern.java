import java.util.HashMap;

/**
 * @program: Leetcode_java
 * @description: 290. Word Pattern
 * @author: Xincheng Huang
 * @create: 2019-03-26 16:05
 **/

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        /*
        Input: pattern = "abba", str = "dog cat cat dog"
         */
        HashMap<Character, String> map = new HashMap<>();
        String[] arr = str.split(" ");

        if (arr.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) return false;
                continue;
            } else if (map.containsValue(arr[i])) return false;
            map.put(c, arr[i]);
        }

        return true;
    }

}
