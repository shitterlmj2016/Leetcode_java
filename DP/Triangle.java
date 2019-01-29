import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: Triangle
 * @description: 120. Triangle
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 22:15
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i-1).get(j);
            }
        }
        return dp[0];
    }


}
