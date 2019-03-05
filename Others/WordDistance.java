import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: WordDistance
 * @description: 244. Shortest Word Distance II
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 11:14
 **/
public class WordDistance {
    private HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> w1 = map.get(word1);// 1 5 6
        List<Integer> w2 = map.get(word2);// 7 9 11
        int w1Index = 0;
        int w2Index = 0;
        //O(m+n)
        while (w1Index < w1.size() && w2Index < w2.size()) {
            int m = w1.get(w1Index);
            int n = w2.get(w2Index);
            min = Math.min(min, Math.abs(m - n));
            if (m < n) {
                w1Index++;
            } else {
                w2Index++;
            }
        }
        return min;
    }
}
