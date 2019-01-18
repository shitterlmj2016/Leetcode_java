import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: GroupAnagrams
 * @description: 49. Group Anagrams
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 21:35
 **/

//有重复的也要放进去

//核心思想： 用sort将string 按字符排序，存到hashset，key是排序后的string，val是string所属组在return 的 list 中的位置
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return list;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if (map.containsKey(sorted)) {
                ArrayList<String> l = (ArrayList) list.get(map.get(sorted));
                l.add(strs[i]);
            } else {
                ArrayList<String> a = new ArrayList<>();
                map.put(sorted, list.size());
                a.add(strs[i]);
                list.add(a);
            }
        }
        return list;
    }
}
