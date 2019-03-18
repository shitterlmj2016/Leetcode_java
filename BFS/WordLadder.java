import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is a comment!
 *
 * @class: WordLadder
 * @description: 127. Word Ladder
 * @author: Xincheng Huang - xinchenh
 * @create: 02-02-2019 22:08
 **/
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        int currNum = 1; //记录这一层有多少个元素，用完之后层数++
        int nextNum = 0; //记录下一层有多少个元素

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            currNum--;
            for (int i = 0; i < temp.length(); i++) {
                char[] array = temp.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    array[i] = j;
                    String res = new String(array);
                    if (set.contains(res)) {
                        if (res.equals(endWord))
                            return ++level;
                        nextNum++;
                        queue.offer(res);
                        set.remove(res);
                    }

                }
            }

            if (currNum == 0) {
                currNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}
