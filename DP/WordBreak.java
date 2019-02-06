import java.util.List;

/**
 * This is a comment!
 *
 * @class: WordBreak
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 02-04-2019 09:30
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null)
            return true;
        if (wordDict == null || wordDict.size() == 0)
            return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
