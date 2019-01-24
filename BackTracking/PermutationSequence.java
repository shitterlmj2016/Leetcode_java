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
    public String getPermutation2(int n, int k) {

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
            if (s.charAt(i)-'0'== num)
                return false;
        }
        return true;
    }













    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
       System.out.println(p.getPermutation(3,3));

    }

}
