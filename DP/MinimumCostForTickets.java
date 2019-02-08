import java.util.HashSet;

/**
 * This is a comment!
 *
 * @class: MinimumCostForTickets
 * @description: Minimum Cost For Tickets
 * @author: Xincheng Huang - xinchenh
 * @create: 02-07-2019 21:06
 **/
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0)
            return 0;
        int dp[] = new int[366];
        HashSet<Integer> set = new HashSet<>();
        for (int i : days
        ) {
            set.add(i);
        }

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i))
                dp[i] = dp[i - 1];
            else {
                int dayMin = dp[i - 1] + costs[0];
                int weekMin = (i > 6) ? (dp[i - 7] + costs[1]) : costs[1];
                int monthMin = (i > 29) ? (dp[i - 30] + costs[2]) : costs[2];
                dp[i] = Math.min(Math.min(dayMin, monthMin), weekMin);
            }
        }
        return dp[dp.length-1];
    }
}
