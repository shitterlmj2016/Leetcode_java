/**
 * This is a comment!
 *
 * @class: EditDistance
 * @description: 72. Edit Distance
 * @author: Xincheng Huang - xinchenh
 * @create: 01-24-2019 17:52
 **/
public class EditDistance {
    /*
    dp[i][j] 表示的是从字符串1的0~i到字符串2的0~j所需要走的步数
    abcd -> aef
    i=1,j=3 把ab变为adef需要的步数

    1. 如果某一字符相等，s1[i] == s2[j] 则 dp[i][j] = dp[i-1][j-1], 因为这一步不需要任何操作
    2. 不等
    1)增加 a->ae:  dp[i][j] = dp[i][j-1]+1
    2)替换 ab->ae: dp[i][j] = dp[i-1][j-1]+1
    3)删除 ab->a   dp[i][j] = dp[i-1][j]+1

size [len1+1][len2+1]
  空 a b c d
空 0 1 2 3 4 删除j个到0
 a 1 0 1 2 3 三个数最小 11.35min视频
 e 2 1 1 2 3
 f 3 2 2 2 3
 从0增加i个

  0代表空，到删除需要做的操作
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1), dp[i - 1][j] + 1); //三者取最小
            }
        }

        return dp[len1][len2];
    }
}
