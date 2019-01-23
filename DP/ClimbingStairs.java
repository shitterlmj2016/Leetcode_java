/**
 * This is a comment!
 *
 * @class: ClimbingStairs
 * @description: 70. Climbing Stairs
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 18:14
 **/

//either climb 1 or 2 steps.
//斐波那契数列
public class ClimbingStairs {
    int res;
/*
5 = (4) + (3) = (3) + (2) +(2) + (1)


 *///O(2^n)
    public int climbStairs(int n) {
        if (n <= 2)
            return n; // n =2 有两种， n = 1 有一种
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //O(n)
    //迭代法
    public int climbStairs2(int n) {
        if (n <= 1)
            return 1; // n =2 有两种， n = 1 有一种
        int oneStep = 1; // 上把走一步的走法
        int twoStep = 1; // 上把走两步的走法
        int res = 0;
        for (int i = 2; i <=n ; i++) {
            res = oneStep + twoStep;//走到这步的走法是两种走法之和
            twoStep = oneStep; //这把走两步的走法是上把走一步的基础上再加一步，数量和上把走一步数量相同
            oneStep = res; // 这把走一步的走法是走到这步的基础上再走一步，数量和走到这步的数量相同
        }
        return res;
    }


    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(3));
    }

}
