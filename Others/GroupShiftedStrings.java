import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: GroupShiftedStrings
 * @description: 249. Group Shifted Strings
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 17:25
 **/
public class GroupShiftedStrings {
    /*
    我的想法： 两个hashmap 长度 -》 string  不同char相减 -》string
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings
        ) {
            int offset = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()
            ) {
                char cc = (char) (c - offset);
                if (cc < 'a')
                    cc += 26;
                sb.append(cc);
            }
            String key = sb.toString();
            System.out.println(key);
            if (map.containsKey(key))
                map.get(key).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()
        ) {
            res.add(list);
        }
        return res;
    }

}
