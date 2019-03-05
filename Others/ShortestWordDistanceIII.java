import java.util.ArrayList;

/**
 * This is a comment!
 *
 * @class: ShortestWordDistanceIII
 * @description: Shortest Word Distance III
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 11:34
 **/
public class ShortestWordDistanceIII {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length;
        ArrayList<Integer> ai = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                ai.add(i);
        }
        if (word1.equals(word2)) {
            for (int i = 1; i < ai.size(); i++) {
                min = Math.min(ai.get(i) - ai.get(i - 1), min);
            }
            return min;
        }

        ArrayList<Integer> aj = new ArrayList<>();
        for (int j = 0; j < words.length; j++) {
            if (words[j].equals(word2))
                aj.add(j);
        }

        for (int k = 0; k < ai.size(); k++) {
            for (int l = 0; l < aj.size(); l++) {
                if (Math.abs((aj.get(l) - ai.get(k))) < min)
                    min = Math.abs((aj.get(l) - ai.get(k)));
            }
        }

        return min;
    }
}
