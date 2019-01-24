import java.util.ArrayList;

/**
 * This is a comment!
 *
 * @class: PermutationSequence
 * @description: 60. Permutation Sequence
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 21:27
 **/
public class PermutationSequence {

    //不一定要回溯，有简便方法
    /*
    1 2 3 4

    1 x x x : 6 个  其中 2 X X 两个
    2 X X X : 6 个
    3 X X X ：6 个

    知道要第几个，就用那个数除每一位的坐标，得到最终答案
     */
    public String getPermutation2(int n, int k) {
        //方法很重要！！！
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(i + 1);
        }

        int[] fact = new int[n];
        fact[0] = 1; //存放每一位有多少个数
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        //  1 2 3 4

        //  1 1 2 6
        StringBuilder sb = new StringBuilder();
        k--;//使得k从0开始 因为k=1其实是表示第0个元素
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            k = k % fact[i];
            sb.append(res.get(index));
            res.remove(index);
        }

        return sb.toString();
    }


    //自己解法回溯很慢
    int n;
    int k;

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0)
            return "";
        ArrayList<String> perm = new ArrayList<>();
        this.n = n;
        this.k = k;
        help(perm, "");
        return perm.get(k - 1);
    }

    private void help(ArrayList<String> perm, String s) {
        if (perm.size() >= k)
            return;
        if (s.length() == n) {
            perm.add(s);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check(s, i)) {
                help(perm, s + i);
            }
        }


    }

    private boolean check(String s, int num) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == num)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3, 3));

    }

}
