import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: IsomorphicStrings
 * @description: Isomorphic Strings
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 23:41
 **/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null || s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (b != map.get(a))
                    return false;
            } else if (!map.containsValue(b)) { //b 有没有被用过，很重要
                map.put(a, b);
            } else
                return false;

        }
        return true;

    }
}
