/**
 * @program: Leetcode_java
 * @description: 312. Burst Balloons
 * @author: Xincheng Huang
 * @create: 2019-03-23 20:21
 **/

public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] arr = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        return helper(arr, dp, 1, nums.length);
    }

    private static int helper(int[] arr, int[][] dp, int i, int j) {
        if (i > j) return 0; //是大于
        if (dp[i][j] != 0) return dp[i][j];
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], helper(arr, dp, i, x - 1)
                    + arr[i - 1] * arr[x] * arr[j + 1] //注意是i-1 和j+1
                    + helper(arr, dp, x + 1, j));
            printArray(dp); // testing
        }
        return dp[i][j];
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        maxCoins(new int[]{3, 1, 5, 8});
    }
}
